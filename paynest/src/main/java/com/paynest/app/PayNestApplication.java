package com.paynest.app;

import com.paynest.domain.Product;
import com.paynest.domain.Customer;
import com.paynest.domain.Order;

public class PayNestApplication {
    public static void main(String[] args) { 
        // Create products
        Product product1 = new Product(1, "Laptop", 12000);
        Product product2 = new Product(2, "Smartphone", 8000.00);
        Product product3 = new Product(3, "Headphones", 1000.00);
        
        // Create customer
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com");

        // Create order
        Order order = new Order(1, customer);

        // Add items to order
        order.addItem(product1, 1);
        order.addItem(product2, 2);
        order.addItem(product3, 1);
        
        // Display order details
        order.displayOrderDetails();
    }
}