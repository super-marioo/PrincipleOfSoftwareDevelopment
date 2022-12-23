package com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility;

import com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility.PizzaRestController.Delivery;
import com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility.PizzaRestController.PizzaOrder;
import jakarta.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {

  private final PriorityQueue<PizzaOrder> pizzaReady =
      new PriorityQueue<>(Comparator.comparing(PizzaOrder::getTimestamp).reversed());
  private final Set<Delivery> pizzaInDelivery = new HashSet<>();

  @PostConstruct
  public void startWork() throws InterruptedException {
    while (true) {
      pickUpForDelivery();
    }
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
}
