package com.paynest.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class ReceiptPrinter {
    // method to render and display order details
    public String displayOrderDetails(Order order) {
        NumberFormat randsFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-ZA"));

        StringBuilder receiptSummary = new StringBuilder();
        receiptSummary.append("\t\u001B[1mPayNest\n")
          .append("----------------------------------\n")
          .append("Order Number: ").append(order.getId()).append("\n")
          .append("Customer Name: ").append(order.getCustomer().getName()).append("\n")
          .append("Customer Email: ").append(order.getCustomer().getEmail()).append("\n")
          .append("----------------------------------\n")
          .append("\t\u001B[1mOrder Items\n")
          .append("----------------------------------\n");

        for (OrderItem item : order.getOrderItems()) {
            receiptSummary.append(item.getProduct().getName())
              .append(" x (Qty)").append(item.getQuantity())
              .append(" = ").append(randsFormatter.format(item.calculateTotal()))
              .append("\n");
        }

        receiptSummary.append("----------------------------------\n")
          .append("Grand Total: ").append(randsFormatter.format(order.calculateTotalAmount()));

        // print to console
        System.out.println(receiptSummary.toString());

        // return for testing
        return receiptSummary.toString();
    }
}
