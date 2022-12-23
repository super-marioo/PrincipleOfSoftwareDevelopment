package com.traning.principleofsoftwaredevelopment.kiss.solution._3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;

public class CommentExample {
  private static final Map<DayOfWeek, DateTimeFormatter> dayOfWeekToDateTimeFormatter =
      Map.ofEntries(
          Map.entry(DayOfWeek.MONDAY, DateTimeFormatter.ofPattern("dd-MM")),
          Map.entry(DayOfWeek.TUESDAY, DateTimeFormatter.ofPattern("dd-MM-yyyy")),
          Map.entry(DayOfWeek.WEDNESDAY, DateTimeFormatter.ofPattern("dd-MM-yyyy")),
          Map.entry(DayOfWeek.THURSDAY, DateTimeFormatter.ofPattern("dd-MM-yyyy")),
          Map.entry(DayOfWeek.FRIDAY, DateTimeFormatter.ofPattern("yyyy")),
          Map.entry(DayOfWeek.SATURDAY, DateTimeFormatter.ofPattern("yyyy")),
          Map.entry(DayOfWeek.SUNDAY, DateTimeFormatter.ofPattern("yyyy")));

  public long add(int val1, int val2) {
    return val1 + val2;
  }

  public String dateToString(LocalDate localDate) {
    return dayOfWeekToDateTimeFormatter.get(localDate.getDayOfWeek()).format(localDate);
  }
}
