package com.traning.principleofsoftwaredevelopment.kiss.solution._2;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class MagicNumbersExample {

  static class DateValidator {
    public boolean isSaturday(LocalDate localDate) {
      return DayOfWeek.SATURDAY.equals(localDate.getDayOfWeek());
    }
  }
}
