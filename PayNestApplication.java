//Product catalogue
//Product class

//package com.paynestsystem.domain;

import java.util.ArrayList;
import java.util.List;

class Product {
    private int id;
    private String name;
    private double price;

    // Constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getters
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
}

//Customer class
class Customer {
    private int id;
    private String name;
    private String email;

    // Constructor
    public Customer(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
//Class for order and order item
class Order {
    private int id;
    private Customer customer; 
    private List<OrderItem> orderItem;

    // Constructor
    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.orderItem = new ArrayList<>();
    }

    //

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

    //Class order item
    class OrderItem {
        private Product product;
        private int quantity;

        public OrderItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }

        public Product getProduct() {
            return product;
        }
        public void setProduct(Product product) {
            this.product = product;
        }
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public double calculateTotal() {
            return product.getPrice() * quantity;
        }
    }

    // Method to add item to order
    public int addItem(Product product, int quantity){
        // Add item to order list
        if(quantity > 0){
            OrderItem item = new OrderItem(product, quantity);
            orderItem.add(item);
            return orderItem.size();
        }else{
            return -1;
        }
    }

    //method to calculate total order amount
    public double calculateTotalAmount(){
        double totalAmount = 0.0;
        for(OrderItem item : orderItem){
            totalAmount += item.calculateTotal();
        }
        return totalAmount;
    }

    //method to display order details
    public void displayOrderDetails(){
        System.err.println("\tInvoice");
        System.err.println("---------------------------");
        System.out.println("Order ID: " + id);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("Order Items");
        for(OrderItem item : orderItem){
            System.out.println("- " + item.product.getName() + " x " + item.quantity + " = R" + item.calculateTotal());
        }
        System.out.println("Grand Total Amount: R" + calculateTotalAmount());
    }
}  

public class PayNestApplication {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product(1, "Laptop", 12000);
        Product product2 = new Product(2, "Smartphone", 8000.00);
        
        // Create customer
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com");

        // Create order
        Order order = new Order(1, customer);
        // Add items to order
        order.addItem(product1, 1);
        order.addItem(product2, 2);
        // Display order details
        order.displayOrderDetails();
    }
}