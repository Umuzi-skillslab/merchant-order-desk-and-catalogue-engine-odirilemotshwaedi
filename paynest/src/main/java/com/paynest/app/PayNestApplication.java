package com.paynest.app;

import com.paynest.domain.Product;
import com.paynest.domain.Customer;
import com.paynest.domain.Order;
import com.paynest.service.OrderService;
import com.paynest.service.ReceiptService;
import com.paynest.service.CatalogueService;

public class PayNestApplication {
    public static void main(String[] args) {
        Product product1 = new Product(1,"Laptop", 12000);
        Product product2 = new Product(2,"Smartphone", 8000);
        Product product3 = new Product(3,"Headphones", 1000);

        // Catalogue and services
        CatalogueService catalogue = new CatalogueService();
        catalogue.addProduct(product1);
        catalogue.addProduct(product2);
        catalogue.addProduct(product3);

        // Create customer and order via service
        Customer customer = new Customer(1, "John Doe","john.doe@example.com");
        OrderService service = new OrderService();
        Order order = service.createOrder(1, customer);

        // Add items from catalogue
        service.addItem(order, product1, 1);
        service.addItem(order, product2, 2);
        service.addItem(order, product3, 1);

        // Display order details (render-only)
        ReceiptService receipt = new ReceiptService();
        System.out.println(receipt.render(order));
    }
}