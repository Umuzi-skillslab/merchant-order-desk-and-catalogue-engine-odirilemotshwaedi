package com.paynest.service;

import com.paynest.domain.Order;
import com.paynest.domain.ReceiptPrinter;

public class ReceiptService {
    ReceiptPrinter printer = new ReceiptPrinter();

    public String render(Order order) {
        return printer.displayOrderDetails(order);
    }
}
