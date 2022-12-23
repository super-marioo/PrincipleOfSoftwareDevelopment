package com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility;

import com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility.PizzaRestController.Pizza;
import java.util.Optional;
import java.util.Set;

public class PizzaValidator {

  public static final Set<String> PIZZA_TYPES = Set.of("margherita", "peperoni", "hawaii");
  public static final Set<String> PIZZA_SIZES = Set.of("xs", "s", "m", "l", "xl", "xxl");
  public static final Set<String> ALLOWED_EXTRAS =
      Set.of("extra cheese", "extra beacon", "extra ham");

  record Error(String msg) {}

  public Optional<Error> hasError(Pizza pizza) {
    if (pizza == null) {
      return Optional.of(new Error("Pizza not defined"));
    }

    if (pizza.getType() == null || !PIZZA_TYPES.contains(pizza.getType())) {
      return Optional.of(
          new Error("Invalid pizza type. Allowed types are " + String.join(",", PIZZA_TYPES)));
    }

    if (pizza.getSize() == null || !PIZZA_SIZES.contains(pizza.getSize())) {
      return Optional.of(
          new Error("Invalid pizza size. Allowed sizes are " + String.join(",", PIZZA_SIZES)));
    }

    if (pizza.getExtras() != null && !ALLOWED_EXTRAS.containsAll(pizza.getExtras())) {
      return Optional.of(
          new Error("Invalid pizza extras. Allowed only " + String.join(",", ALLOWED_EXTRAS)));
    }

    return Optional.empty();
  }
}
