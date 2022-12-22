package com.traning.principleofsoftwaredevelopment.solid.problem.openclose._2;

import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class DataPrinterService {
  private final BlackAndWhitePrinter printer;

  public DataPrinterService(BlackAndWhitePrinter printer) {
    this.printer = printer;
  }

  public void print(String data, PageSize format) {
    // split text to fit page
    var rows = List.of("....");

    if (printer.isFormatSupported(format)) {
      printer.print(rows);
    }
  }
}

@Service
class BlackAndWhitePrinter {
  boolean isFormatSupported(PageSize pageSize) {
    return PageSize.A4.equals(pageSize);
  }

  void print(List<String> rows) {
    // ...logic
  }
}

enum PageSize {
  A4
}

class Page {
  private List<String> rows;
}
// 1. how to change this code to be more open/close ?

// 2. we want to add new printer and support A3 page size ?
