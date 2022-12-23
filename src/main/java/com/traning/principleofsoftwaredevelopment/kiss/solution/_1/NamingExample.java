package com.traning.principleofsoftwaredevelopment.kiss.solution._1;

public class NamingExample {

  static class Calculator {
    public int add7thAnd8thChar(String stringData) {
      if (stringData.length() < 9) {
        throw new RuntimeException();
      }

      // more logic here
      int relevantNameDescribingIndex8 = 8;
      var ascii8 = stringData.charAt(relevantNameDescribingIndex8);
      int relevantNameDescribingIndex7 = 7;
      var ascii7 = stringData.charAt(relevantNameDescribingIndex7);

      // more logic

      return ascii8 + ascii7;
    }

    public double add(double x, double y) {
      return x + y;
    }
  }
}
