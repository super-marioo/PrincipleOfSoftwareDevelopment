package com.traning.principleofsoftwaredevelopment.solid.solution.openclose._2;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DataPrinterService {
  private final List<Printable> printer;

  public void print(String data, PageSize format) {
    // split text to fit page
    var rows = List.of("....");

    // more logic....

    printer.stream().filter(z -> z.isFormatSupported(format)).forEach(p -> p.print(rows));
  }
}

interface Printable {
  boolean isFormatSupported(PageSize pageSize);

  void print(List<String> rows);
}

@Service
class BlackAndWhitePrinter implements Printable {
  public boolean isFormatSupported(PageSize pageSize) {
    return PageSize.A4.equals(pageSize);
  }

  public void print(List<String> rows) {
    // ...logic
  }
}

@Service
class A3Printer implements Printable {
  public boolean isFormatSupported(PageSize pageSize) {
    return PageSize.A3.equals(pageSize);
  }

  public void print(List<String> rows) {
    // ...logic
  }
}

@Service
class A2Printer implements Printable {
  public boolean isFormatSupported(PageSize pageSize) {
    return PageSize.A3.equals(pageSize);
  }

  public void print(List<String> rows) {
    // ...logic
  }
}

enum PageSize {
  A4,
  A3,
  A2
}

class Page {
  private List<String> rows;
}
