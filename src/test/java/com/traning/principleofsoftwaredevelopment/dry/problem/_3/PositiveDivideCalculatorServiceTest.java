package com.traning.principleofsoftwaredevelopment.dry.problem._3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.traning.principleofsoftwaredevelopment.dry.problem._3.PositiveDivideCalculatorService.NotAPositiveResultException;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositiveDivideCalculatorServiceTest {

  private final PositiveDivideCalculatorService cut = new PositiveDivideCalculatorService();

  @Test
  public void testDivideOfInt() {
    // given
    var x = 100;
    var y = 2;

    // when
    var result = cut.divide(x, y);

    // then
    assertEquals(50, result);
  }

  @Test
  public void testDivideOfIntByZero() {
    // given
    var x = 100;
    var y = 0;

    // when
    var exception = Assertions.assertThrows(ArithmeticException.class, () -> cut.divide(x, y));

    // then
    assertEquals("/ by zero", exception.getMessage());
  }

  @Test
  public void testDivideOfDouble() {
    // given
    var x = 100.100555;
    var y = 2;

    // when
    var result = cut.divide(x, y);

    // then
    assertEquals(50.0502775, result);
  }

  @Test
  public void testDivideOfDoubleByZero() {
    // given
    var x = 100d;
    var y = 0d;

    // when
    var result = cut.divide(x, y);

    // then
    assertEquals(Double.POSITIVE_INFINITY, result);
  }

  @Test
  public void testDivideOfBigDecimal() {
    // given
    var x = new BigDecimal("100.100555");
    var y = new BigDecimal("2");

    // when
    var result = cut.divide(x, y);

    // then
    assertEquals(new BigDecimal("50.05"), result);
  }

  @Test
  public void testDivideOfBigDecimalByZero() {
    // given
    var x = new BigDecimal("100.100555");
    var y = BigDecimal.ZERO;

    // when
    var exception = Assertions.assertThrows(ArithmeticException.class, () -> cut.divide(x, y));

    // then
    assertEquals("/ by zero", exception.getMessage());
  }

  @Test
  public void testDivideOfNegativeInt() {
    // given
    var x = -100;
    var y = 99;

    // when
    // then
    Assertions.assertThrows(NotAPositiveResultException.class, () -> cut.divide(x, y));
  }

  @Test
  public void testDivideOfNegativeDouble() {
    // given
    var x = -0.2;
    var y = 0.1;

    // when
    // then
    Assertions.assertThrows(NotAPositiveResultException.class, () -> cut.divide(x, y));
  }

  @Test
  public void testDivideOfNegativeBigDecimal() {
    // given
    var x = new BigDecimal("-100.100");
    var y = new BigDecimal("99.01");

    // when
    // then
    Assertions.assertThrows(NotAPositiveResultException.class, () -> cut.divide(x, y));
  }
}
