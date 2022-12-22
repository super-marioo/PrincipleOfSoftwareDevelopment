package com.traning.principleofsoftwaredevelopment.dry.problem._2;

import java.math.BigDecimal;

public class PositiveSumCalculatorService {
  public long add(int a, int b) {
    var result = a + b;

    if (result < 0) {
      throw new NotAPositiveResultException();
    }

    return result;
  }

  public double add(double a, double b) {
    var result = a + b;

    if (result < 0) {
      throw new NotAPositiveResultException();
    }

    return result;
  }

  public BigDecimal add(BigDecimal a, BigDecimal b) {
    var result = a.add(b);

    if (result.signum() < 0) {
      throw new NotAPositiveResultException();
    }

    return result;
  }

  public static class NotAPositiveResultException extends RuntimeException {}
}
