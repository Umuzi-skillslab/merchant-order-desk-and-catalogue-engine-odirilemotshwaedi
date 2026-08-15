package com.paynest.domain;

import java.text.NumberFormat;
import java.util.Locale;

//ReceiptPrinter is responsible for formatting order details into a receipt string.
//Adheres to IO-separation principle by returning strings only, with no side effects.
public class ReceiptPrinter {
    private static final String receiptSeparator = "----------------------------------\n";
    private static final String BOLD = "\u001B[1m";
    private static final NumberFormat RAND_FORMATTER = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-ZA"));

    //Generates a formatted receipt string for an order.
    public String displayOrderDetails(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }

        StringBuilder header = new StringBuilder();
        header.append("\t").append(BOLD).append("PayNest\n")
          .append(receiptSeparator);

        StringBuilder customerInfo = new StringBuilder();
          customerInfo.append("Order Number: ").append(order.getId()).append("\n")
          .append("Customer Name: ").append(order.getCustomer().getName()).append("\n")
          .append("Customer Email: ").append(order.getCustomer().getEmail()).append("\n")
          .append(receiptSeparator)
          .append("\t").append(BOLD).append("Order Items\n")
          .append(receiptSeparator);

        StringBuilder orderItems = new StringBuilder();
        for (OrderItem item : order.getOrderItems()) {
            orderItems.append(item.getProduct().getName())
              .append(" x (Qty)").append(item.getQuantity())
              .append(" = ").append(formatCurrency(item.calculateTotal()))
              .append("\n");
        }

        StringBuilder grandTotal = new StringBuilder();
        grandTotal.append(receiptSeparator)
          .append("Grand Total: ").append(formatCurrency(order.calculateTotalAmount()));

        return header.append(customerInfo).append(orderItems).append(grandTotal).toString();
    }

    private String formatCurrency(java.math.BigDecimal amount) {
        return RAND_FORMATTER.format(amount).replace('\u00A0', ' ');
    }
}
