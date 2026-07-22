package com.paynest.domain;

import java.util.ArrayList;
import java.util.List;

//Order class
public class Order {
    private int id;
    private Customer customer; 
    private List<OrderItem> orderItem;

    // Constructor
    public Order(int id, Customer customer) {
        this.id = id;
        this.customer = customer;
        this.orderItem = new ArrayList<>();
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

    
    // Method to add item to order
    public int addItem(Product product, int quantity){
        // Add item to order list
        if(quantity > 0){
            OrderItem item = new OrderItem(product, quantity);
            orderItem.add(item);
            return orderItem.size();
            }
        else{
            throw new IllegalArgumentException("The number of products must be grater than 0");
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
        int totalOrders = 0;

        System.out.println("\t\u001B[1mPayNest");
        System.out.println("-----------------------------------");
        System.out.println("Order Number: " + id);
        System.out.println("Customer Name: " + customer.getName());
        System.out.println("Customer Email: *************");
        System.out.println("-----------------------------------");
        System.out.println("\t\u001B[1mOrder Items");
        System.out.println("-----------------------------------");
        for(OrderItem item : orderItem){
            System.out.println(""+ item.getProduct().getName() + " x " + item.getQuantity() + " = R" + item.calculateTotal());
            totalOrders = totalOrders+ item.getQuantity() ;
        } 
        System.out.println("-----------------------------------");
        System.out.println("Total Amount For "+totalOrders+" Items: R" + calculateTotalAmount());
        System.out.println("-----------------------------------");
        System.out.println("Thank You For Shopping With Us \n    Go to www.paynest.co.za \n       Tel: 012 559 0509");
    }

} 