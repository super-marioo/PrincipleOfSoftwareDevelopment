package com.traning.principleofsoftwaredevelopment.dry.solution._2;

import java.math.BigDecimal;

public class PositiveSumCalculatorService {
  public long add(int a, int b) {
    return add(BigDecimal.valueOf(a), BigDecimal.valueOf(b)).longValue();
  }

  public double add(double a, double b) {
    return add(BigDecimal.valueOf(a), BigDecimal.valueOf(b)).doubleValue();
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
