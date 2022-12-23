package com.traning.principleofsoftwaredevelopment.kiss.solution._4;

import java.time.DayOfWeek;
import java.util.Map;
import java.util.Optional;

/** Source : https://www.c-sharpcorner.com/article/software-design-principles-dry-kiss-yagni/ */
public class KissExamples {
  private static final Map<Integer, String> DAY_OF_WEEK_TO_NAME =
      Map.ofEntries(
          Map.entry(1, "Monday"),
          Map.entry(2, "Tuesday"),
          Map.entry(3, "Wednesday"),
          Map.entry(4, "Thursday"),
          Map.entry(5, "Friday"),
          Map.entry(6, "Saturday"),
          Map.entry(7, "Sunday"));

  // 1. voted as most KISS
  public String weekday(int day) {
    return switch (day) {
      case 1 -> "Monday";
      case 2 -> "Tuesday";
      case 3 -> "Wednesday";
      case 4 -> "Thursday";
      case 5 -> "Friday";
      case 6 -> "Saturday";
      case 7 -> "Sunday";
      default -> throw new InvalidOperationException("day must be in range 1 to 7");
    };
  }

  // 2. Can we make the chosen version better ? (without java specific ?)
  public String weekday2(int day) {
    return Optional.ofNullable(DAY_OF_WEEK_TO_NAME.get(day))
        .orElseThrow(() -> new InvalidOperationException("day must be in range 1 to 7"));
  }

  // 3. Extra: can we make it better using Java specific ?
  public String weekday3(int day) {
    return DayOfWeek.of(day).name();
  }

  static class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String msg) {
      super(msg);
    }
  }
}
