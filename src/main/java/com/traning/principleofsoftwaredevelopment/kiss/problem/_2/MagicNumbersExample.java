package com.traning.principleofsoftwaredevelopment.kiss.problem._2;

import java.time.LocalDate;

public class MagicNumbersExample {


  static class DateValidator {
    public boolean isDateValid(LocalDate localDate) {
      return localDate.getDayOfWeek().ordinal() == 6;
    }
  }
}
