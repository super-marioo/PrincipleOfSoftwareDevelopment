package com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility;

import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/order/pizzas")
public class PizzaRestController {

  private final PizzaValidator pizzaValidator;
  private final BakeService bakeService;
  private final PizzaStatusService pizzaStatusService;
  private final InvoiceService invoiceService;

  @PostMapping
  public ResponseEntity<String> orderPizza(Pizza pizza) {
    return pizzaValidator
        .hasError(pizza)
        .map(error -> ResponseEntity.badRequest().body(error.msg()))
        .orElseGet(
            () -> {
              var orderId = UUID.randomUUID();
              bakeService.add(new PizzaOrder(pizza, orderId, System.currentTimeMillis()));

              return ResponseEntity.ok(String.valueOf(orderId));
            });
  }

  @GetMapping("/{orderId}/status")
  public ResponseEntity<String> checkOrderStatus(@Validated @NotNull @PathVariable UUID orderId) {
    return ResponseEntity.ok(pizzaStatusService.status(orderId));
  }

  @PostMapping("/{orderId}/invoice")
  public ResponseEntity<byte[]> getInvoice(
      @Validated @NotNull @PathVariable UUID orderId, @RequestBody String invoiceData) {
    return ResponseEntity.ok(invoiceService.generateInvoice(orderId, invoiceData));
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
