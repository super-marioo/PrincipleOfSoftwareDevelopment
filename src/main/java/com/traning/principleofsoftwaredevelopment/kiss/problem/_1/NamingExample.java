package com.traning.principleofsoftwaredevelopment.kiss.problem._1;

import java.time.LocalDate;

public class NamingExample {
  static class Calculator {
    public long calculate(String y) {

      var x1 = y.charAt(8);
      var x2 = y.charAt(7);

      return x1 + x2;
    }

    public double rollbackAdd(double accountBalance, double transactionCost) {
      return accountBalance + transactionCost;
    }
  }
}
