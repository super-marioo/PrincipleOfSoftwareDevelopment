package com.traning.principleofsoftwaredevelopment.kiss.problem._4;

/** Source : https://www.c-sharpcorner.com/article/software-design-principles-dry-kiss-yagni/ */
public class KissExamples {

  /*
  1. Ver 1 vs ver 2 ? Which one do you consider more 'kiss' ?
  2. Can we make the chosen version better ? (without java specific ?)
  3. Extra: can we make it better using Java specific ?
  * */
  public String weekday1(int day) {
    switch (day) {
      case 1:
        return "Monday";
      case 2:
        return "Tuesday";
      case 3:
        return "Wednesday";
      case 4:
        return "Thursday";
      case 5:
        return "Friday";
      case 6:
        return "Saturday";
      case 7:
        return "Sunday";
      default:
        throw new InvalidOperationException("day must be in range 1 to 7");
    }
  }

  public String weekday2(int day) {
    if ((day < 1) || (day > 7)) throw new InvalidOperationException("day must be in range 1 to 7");
    String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

    return days[day - 1];
  }

  // old version might be useful later
  public String weekday3_OLD(int day) {
    String[] workDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    String[] weekDays = {"Saturday", "Sunday"};

    if (day > 0 && day < workDays.length) {
      return workDays[day - 1];
    }

    if (day > workDays.length && day < workDays.length + weekDays.length) {
      return weekDays[day - workDays.length];
    }

    throw new InvalidOperationException("day must be in range 1 to 7");
  }

  static class InvalidOperationException extends RuntimeException {
    public InvalidOperationException(String msg) {
      super(msg);
    }
  }
}
