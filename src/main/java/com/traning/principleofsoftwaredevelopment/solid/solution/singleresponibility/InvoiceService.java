package com.traning.principleofsoftwaredevelopment.solid.solution.singleresponibility;

import java.nio.charset.StandardCharsets;
import java.util.UUID;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

  public byte[] generateInvoice(UUID orderId, String invoiceData) {
    var invoiceFileContent = "Invoice for order " + orderId + "......";
    // generate all data about invoice

    return invoiceFileContent.getBytes(StandardCharsets.UTF_8);
  }
}
