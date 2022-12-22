package com.traning.principleofsoftwaredevelopment.dry.problem._1;

public class HtmlService {

  public String getSpan(String title) {
    return String.format(
        """
        <span style="color: #28462C">
          %s
        </span>
        """,
        title);
  }

  public String getDiv(String title) {
    return String.format(
        """
        <div style="color: #28462C">
          %s
        </div>
        """,
        title);
  }

  public String getParagraph(String title) {
    return String.format(
        """
        <p style="color: #28462C">
          %s
        </p>
        """,
        title);
  }

  /*
   * 1. How can we make it "more DRY" ?
   * 2. What would be premature refactoring ?
   */
}
