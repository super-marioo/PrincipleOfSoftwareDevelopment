package com.traning.principleofsoftwaredevelopment.dry.solution._1;

import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.web.util.HtmlUtils;

public class HtmlService {

  // ... dependencies
  enum Element {
    div,
    span,
    p,
    h1,
    h2
  }

  // 1. How can we make it "more DRY" ?
  public String getElement(String title, Element element) {
    return String.format(
        """
        <%s style="color: #28462C" class="class">
          %s
        </%s>
        """,
        element, HtmlUtils.htmlEscape(title), element);
  }

  // 2. What would be premature refactoring ?
  public String getElement(String title, Element element, Map<String, String> attributes) {
    return "<"
        + element.name().toLowerCase()
        + attributes.entrySet().stream()
            .map(a -> a.getKey() + "=\"" + a.getValue() + "\"")
            .collect(Collectors.joining(" "))
        + HtmlUtils.htmlEscape(title)
        + "</"
        + element.name().toLowerCase()
        + ">";
  }
}
