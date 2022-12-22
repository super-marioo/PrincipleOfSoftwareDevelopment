package com.traning.principleofsoftwaredevelopment.dry.problem._2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.traning.principleofsoftwaredevelopment.dry.problem._2.PositiveSumCalculatorService.NotAPositiveResultException;
import java.math.BigDecimal;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PositiveSumCalculatorServiceTest {

  private final PositiveSumCalculatorService cut = new PositiveSumCalculatorService();

  @Test
  public void testAddOfInt() {
    // given
    var x = 100;
    var y = 99;

    // when
    var result = cut.add(x, y);

    // then
    assertEquals(199, result);
  }


  @Test
  public void testAddOfDouble() {
    // given
    var x = 0.1;
    var y = 0.1;

    // when
    var result = cut.add(x, y);

    // then
    assertEquals(0.2d, result);
  }

  @Test
  public void testAddOfDoubleChain() {
    // given
    var x = 0.1;
    var y = 0.1;

    // when
    var result = cut.add(x, y) + cut.add(x, y) + cut.add(x, y);

    // then
    assertEquals(0.6000000000000001d, result);
  }

  @Test
  public void testAddOfBigDecimal() {
    // given
    var x = new BigDecimal("100.100");
    var y = new BigDecimal("99.01");

    // when
    var result = cut.add(x, y);

    // then
    assertEquals(new BigDecimal("199.110"), result);
  }

  @Test
  public void testAddOfNegativeInt() {
    // given
    var x = -100;
    var y = 99;

    // when
    // then
    Assertions.assertThrows(NotAPositiveResultException.class, () -> cut.add(x, y));
  }

  @Test
  public void testAddOfNegativeDouble() {
    // given
    var x = -0.2;
    var y = 0.1;

    // when
    // then
    Assertions.assertThrows(NotAPositiveResultException.class, () -> cut.add(x, y));
  }

  @Test
  public void testAddOfNegativeBigDecimal() {
    // given
    var x = new BigDecimal("-100.100");
    var y = new BigDecimal("99.01");

    // when
    // then
    Assertions.assertThrows(NotAPositiveResultException.class, () -> cut.add(x, y));
  }
}
