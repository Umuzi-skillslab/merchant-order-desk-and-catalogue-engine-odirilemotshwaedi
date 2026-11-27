package com.paynest.service;

import com.paynest.domain.Order;
import java.math.BigDecimal;
import com.paynest.domain.Customer;
import com.paynest.domain.Product;

public class OrderService{
    public Order createOrder(int orderId, Customer customer){
        return new Order(orderId, customer);
    }

    // Method to add item to order (defensive)
    public void addItem(Order order, Product product, int quantity){
        if (order == null) throw new NullPointerException("Order cannot be null");
        order.addItem(product, quantity);
    }

    // calculates the total amount of the order
    public BigDecimal calculateOrderTotal(Order order){
        if (order == null) throw new NullPointerException("Order cannot be null");
        return order.calculateTotalAmount();
    }
}
