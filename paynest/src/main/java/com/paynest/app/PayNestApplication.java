package com.paynest.app;

import com.paynest.domain.Product;
import com.paynest.domain.Customer;
import com.paynest.domain.Order;
import com.paynest.domain.ReceiptPrinter;
import com.paynest.service.OrderService;

public class PayNestApplication {
    public static void main(String[] args) { 
        // Create products
        Product product1 = new Product(1,"Laptop", 12000);
        Product product2 = new Product(2,"Smartphone", 8000);
        Product product3 = new Product(3,"Headphones", 1000);
        
        // Create customer
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com");

        // Create order
        //Order order = new Order(1, customer);
        OrderService service = new OrderService();
        Order order = service.createORder(1, customer);

        // Add items to order
        service.addItem(order, product1, 1);
        service.addItem(order, product2, 2);
        service.addItem(order, product3, 1);
        
        // Display order details
        ReceiptPrinter orderSummary = new ReceiptPrinter();
        orderSummary.displayOrderDetails(order);
    }
}