package com.paynest.domain;

import com.paynest.payment.CurrencyFormatter;

//Formats order information as a receipt
public class ReceiptPrinter {
    private static final String RECEIPT_SEPARATOR = "\n----------------------------------------";
    private static final String BOLD = "\u001B[1m";

    //Build and return a receipt for the order.
    public String displayOrderDetails(Order order) {

        //validate the order
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }

        //Ensure the order has a customer.
        if (order.getCustomer() == null) {
            throw new IllegalArgumentException("Order must have a customer");
        }

        //Create the receipt header.
        StringBuilder header = new StringBuilder();
        header.append("\t").append(BOLD)
            .append("PayNest")
            .append(RECEIPT_SEPARATOR);

        //Add customer information
        StringBuilder customerInfo = new StringBuilder();
        customerInfo.append("\n")
            .append("Order Number: ")
            .append(order.getId()).append("\n")
            .append("Customer Name: ")
            .append(order.getCustomer().getName()).append("\n")
            .append("Customer Email: ")
            .append(order.getCustomer().getEmail())
            .append(RECEIPT_SEPARATOR)
            .append("\n")
            .append("\t")
            .append(BOLD)
            .append("Order Items")
            .append(RECEIPT_SEPARATOR);

        //Add order items
        StringBuilder orderItems = new StringBuilder();
        for (OrderItem item : order.getOrderItems()) {
            orderItems.append("\n")
                .append(item.getProduct().getName())
                .append(" x (Qty)")
                .append(item.getQuantity())
                .append(" = ")
                .append(formatCurrency(item.calculateTotal()));
        }

        //Add the grand total.
        StringBuilder grandTotal = new StringBuilder();
        grandTotal.append(RECEIPT_SEPARATOR)
            .append("\n")
            .append("Grand Total: ")
            .append(formatCurrency(order.calculateTotalAmount()))
            .append(RECEIPT_SEPARATOR);

        //Add the payment section heading
        StringBuilder paymentBuilder = new StringBuilder();
        paymentBuilder.append("\n")
            .append("\t")
            .append(BOLD).append("Payment")
            .append(RECEIPT_SEPARATOR);

        //Return the complete receipt.
        return header.append(customerInfo)
            .append(orderItems)
            .append(grandTotal)
            .append(paymentBuilder).toString();
    }

    //Format an amount as a South African Rand.
    private String formatCurrency(java.math.BigDecimal amount) {
        return CurrencyFormatter.format(amount);
    }
}
