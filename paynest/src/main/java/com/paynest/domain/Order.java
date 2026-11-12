package com.paynest.domain;

import java.util.ArrayList;
import java.util.List;

import com.paynest.payment.PaymentMethod;
import com.paynest.payment.PaymentProcessor;

import java.util.Collections;
import java.math.BigDecimal;
import java.math.RoundingMode;

//Order class
public class Order {
    private int id;
    private Customer customer;
    private List<OrderItem> orderItem = new ArrayList<>();

    // Constructor
    public Order(int id, Customer customer) {
        if (id <= 0) {
            throw new IllegalArgumentException("Order id must be greater than 0");
        }
        this.id = id;
        this.customer = customer;
    }

    // Getters
    public int getId() {
        return id;
    }
    public Customer getCustomer() {
        return customer;
    }

    //Method to add item to order
    public void addItem(Product product, int quantity){
        if (product == null) {
            throw new NullPointerException("Product cannot be null");
        }
        if(quantity <= 0){
            throw new IllegalArgumentException("Quantity must be greater than zero");
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

    public List<OrderItem> getOrderItems() {
        return Collections.unmodifiableList(orderItem);
    }


    //Checkout orchestration
    public boolean checkout(PaymentMethod paymentMethod){

        if (paymentMethod == null) {
            throw new IllegalArgumentException("Payment method cannot be null");
        }

        //Pass the selected amount to the payment method
        PaymentProcessor paymentProcessor = new PaymentProcessor();
        boolean paymentSuccessful = paymentProcessor.processPayment(paymentMethod, calculateTotalAmount());

        //Order confirmation
        if(paymentSuccessful){

            System.out.println("Order #" + getId()
            + " completed successfully via "
            + paymentMethod.getPaymentType());
        }

        return paymentSuccessful;
    }
}