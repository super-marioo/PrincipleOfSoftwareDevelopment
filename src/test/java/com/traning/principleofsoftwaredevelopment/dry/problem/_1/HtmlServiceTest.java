package com.traning.principleofsoftwaredevelopment.dry.problem._1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class HtmlServiceTest {

  private final HtmlService cut = new HtmlService();
  private final String title = "Some title";

  @Test
  public void testSpan() {
    // given

    // when
    var result = cut.getSpan(title);

    // then
    assertEquals(
        """
        <span style="color: #28462C">
          Some title
        </span>
        """,
        result);
  }

  @Test
  public void testDiv() {
    // given

    // when
    var result = cut.getDiv(title);

    // then
    assertEquals(
        """
        <div style="color: #28462C">
          Some title
        </div>
        """,
        result);
  }

  @Test
  public void testParagraph() {
    // given

    // when
    var result = cut.getParagraph(title);

    // then
    assertEquals(
        """
        <p style="color: #28462C">
          Some title
        </p>
        """,
        result);
  }
}
