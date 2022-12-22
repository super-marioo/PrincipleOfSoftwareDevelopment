package com.traning.principleofsoftwaredevelopment.solid.problem.singleresponibility;

import jakarta.annotation.PostConstruct;
import jakarta.validation.constraints.NotNull;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order/pizzas")
public class PizzaRestController {

  private final PriorityQueue<PizzaOrder> toBeBake =
      new PriorityQueue<>(Comparator.comparing(PizzaOrder::getTimestamp).reversed());

  private final PriorityQueue<PizzaOrder> pizzaReady =
      new PriorityQueue<>(Comparator.comparing(PizzaOrder::getTimestamp).reversed());

  private final Set<Delivery> pizzaInDelivery = new HashSet<>();

  @PostMapping
  public ResponseEntity<?> orderPizza(Pizza pizza) {
    if (pizza == null) {
      return ResponseEntity.badRequest().body("Pizza not defined");
    }

    var pizzaTypes = Set.of("margherita", "peperoni", "hawaii");
    if (pizza.type == null || !pizzaTypes.contains(pizza.type)) {
      return ResponseEntity.badRequest()
          .body("Invalid pizza type. Allowed types are " + String.join(",", pizzaTypes));
    }

    var pizzaSizes = Set.of("xs", "s", "m", "l", "xl", "xxl");
    if (pizza.size == null || !pizzaSizes.contains(pizza.size)) {
      return ResponseEntity.badRequest()
          .body("Invalid pizza size. Allowed sizes are " + String.join(",", pizzaSizes));
    }

    var allowedExtras = Set.of("extra cheese", "extra beacon", "extra ham");
    if (pizza.extras != null && !allowedExtras.containsAll(pizza.extras)) {
      return ResponseEntity.badRequest()
          .body("Invalid pizza extras. Allowed only " + String.join(",", allowedExtras));
    }

    var orderId = UUID.randomUUID();
    toBeBake.add(new PizzaOrder(pizza, orderId, System.currentTimeMillis()));

    return ResponseEntity.ok(orderId);
  }

  @GetMapping("/{orderId}/status")
  public ResponseEntity<String> checkOrderStatus(@Validated @NotNull @PathVariable UUID orderId) {
    if (pizzaInDelivery.stream().map(Delivery::getOrderId).anyMatch(orderId::equals)) {
      return ResponseEntity.ok("In Delivery");
    }

    if (pizzaReady.stream().map(PizzaOrder::getOrderId).anyMatch(orderId::equals)) {
      return ResponseEntity.ok("Ready to be deliver");
    }

    if (toBeBake.stream().map(PizzaOrder::getOrderId).anyMatch(orderId::equals)) {
      return ResponseEntity.ok("In preparation");
    }

    return ResponseEntity.badRequest().body("Unknown status");
  }

  @PostMapping("/{orderId}/invoice")
  public ResponseEntity<byte[]> getInvoice(
      @Validated @NotNull @PathVariable UUID orderId, @RequestBody String invoiceData) {
    var invoiceFileContent = "Invoice for order " + orderId + "......";
    // generate all data about invoice

    return ResponseEntity.ok(invoiceFileContent.getBytes(StandardCharsets.UTF_8));
  }

  @PostConstruct
  public void startWork() throws InterruptedException {
    while (true) {
      bakePizza();
      pickUpForDelivery();
    }
  }

  private void bakePizza() throws InterruptedException {
    while (toBeBake.isEmpty()) {
      wait(50000);
    }

    while (isMaxPizzaInBake()) {
      wait(50000);
    }

    new Thread(
            () -> {
              PizzaOrder pizzaOrder = toBeBake.poll();
              doBaking(pizzaOrder);

              pizzaReady.add(pizzaOrder);
            })
        .start();
  }

  private void pickUpForDelivery() throws InterruptedException {
    while (pizzaReady.isEmpty()) {
      wait(50000);
    }

    while (!isAnyDeliveryManAvailable()) {
      wait(50000);
    }

    new Thread(() -> deliverPizza(pizzaReady.poll())).start();
  }

  private boolean isAnyDeliveryManAvailable() {
    return true;
  }

  private void deliverPizza(PizzaOrder order) {
    pizzaInDelivery.add(new Delivery(order.getOrderId(), LocalDateTime.now().plusMinutes(15)));
    // logic
  }

  private void doBaking(PizzaOrder order) {
    // logic

    // when done move to
  }

  private boolean isMaxPizzaInBake() {
    // logic...
    return false;
  }

  // ------
  @Data
  @AllArgsConstructor
  @NoArgsConstructor
  static class Pizza {
    private String type;
    private String size;
    private Set<String> extras;
  }

  @Value
  static class PizzaOrder {
    Pizza pizza;

    UUID orderId;
    long timestamp;
  }

  @Value
  static class Delivery {
    UUID orderId;
    LocalDateTime eta;
  }
}
