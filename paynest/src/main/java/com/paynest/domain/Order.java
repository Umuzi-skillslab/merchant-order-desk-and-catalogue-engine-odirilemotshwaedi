package com.paynest.domain;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

//Order class
public class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> orderItem = new ArrayList<>();

    public Order(){
    }

    // Constructor
    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Customer getCustomer() {
        return customer;
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
    public List<OrderItem> getOrderItem(){
        return orderItem;
    }

    //Method to add item to order

    public void addItem(Product product, int quantity){
        if(quantity <= 0){
            throw new IllegalArgumentException("The number of products must be greater than 0");
        }
        orderItem.add(new OrderItem(product, quantity));
    }

    //method to calculate total order amount
    public BigDecimal calculateTotalAmount(){
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(OrderItem item : orderItem){
            totalAmount = totalAmount.add(item.calculateTotal());
        }
        return totalAmount.setScale(2,RoundingMode.HALF_UP);
    }

    NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();

    public String OrderSummary(){
        StringBuilder summary = new StringBuilder();
        for(OrderItem item : orderItem){
            summary.append(item.getProduct().getName()).append(" x (Qty)").append(item.getQuantity()).append(" = ").append(currencyFormatter.format(item.calculateTotal())).append("\n");
        }
        summary.append("----------------------------------\n").append("Grand Total: ").append(currencyFormatter.format(calculateTotalAmount())).append("\n");
        return summary.toString();
    }
}