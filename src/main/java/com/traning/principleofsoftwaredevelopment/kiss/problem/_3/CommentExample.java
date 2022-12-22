package com.traning.principleofsoftwaredevelopment.kiss.problem._3;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CommentExample {

  /** It returns absolut sum value */
  public long add(int val1, int val2) {
    return val1 + val2;
  }

  /** It returns string representation of Date */
  public String dateToString(LocalDate localDate) {

    // if monday - do not show year
    if (localDate.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM");
      return dateTimeFormatter.format(localDate);
    } else if ((localDate.getDayOfWeek().equals(DayOfWeek.TUESDAY)
            || localDate.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)
            || localDate.getDayOfWeek().equals(DayOfWeek.THURSDAY))
        && !localDate.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
      return dateTimeFormatter.format(localDate);
    } else { // if weekend - show only year!
      DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy");
      return dateTimeFormatter.format(localDate);
    }
  }
}
