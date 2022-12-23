package com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility;

import com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility.PizzaRestController.PizzaOrder;
import jakarta.annotation.PostConstruct;
import java.util.Comparator;
import java.util.PriorityQueue;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class BakeService {
  private final ApplicationEventPublisher applicationEventPublisher;
  private final PriorityQueue<PizzaOrder> toBeBake =
      new PriorityQueue<>(Comparator.comparing(PizzaOrder::getTimestamp).reversed());

  @PostConstruct
  public void startWork() throws InterruptedException {
    while (true) {
      bakePizza();
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
              applicationEventPublisher.publishEvent(
                  new ApplicationEvent(this) {
                    public final PizzaOrder ready = pizzaOrder;

                    @Override
                    public Object getSource() {
                      return super.getSource();
                    }
                  });
            })
        .start();
  }

  private void doBaking(PizzaOrder order) {
    // logic

    // when done move to
  }

  private boolean isMaxPizzaInBake() {
    // logic...
    return false;
  }

  public void add(PizzaOrder pizzaOrder) {
    this.toBeBake.add(pizzaOrder);
  }
}
