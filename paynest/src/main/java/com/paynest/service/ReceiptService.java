package com.paynest.service;

import com.paynest.domain.Order;
import com.paynest.domain.ReceiptPrinter;

// Validates inputs and delegates formatting to ReceiptPrinter.
public class ReceiptService {
    private final ReceiptPrinter printer;

    public ReceiptService() {
        this.printer = new ReceiptPrinter();
    }

    //returnS a receipt asa string
    public String render(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Cannot render receipt for null order"); 
        }
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }
        return printer.displayOrderDetails(order);
    }
}
