package com.traning.principleofsoftwaredevelopment.dry.problem._3;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class PositiveDivideCalculatorService {

  public long divide(int a, int b) {
    var result = a / b;

    if (result < 0) {
      throw new NotAPositiveResultException();
    }

    return result;
  }

  public double divide(double a, double b) {
    var result = a / b;

    if (result < 0) {
      throw new NotAPositiveResultException();
    }

    return result;
  }

  public BigDecimal divide(BigDecimal a, BigDecimal b) {
    var result = a.divide(b, 2, RoundingMode.HALF_DOWN);

    if (result.signum() < 0) {
      throw new NotAPositiveResultException();
    }

    return result;
  }

  public static class NotAPositiveResultException extends RuntimeException {}
}
