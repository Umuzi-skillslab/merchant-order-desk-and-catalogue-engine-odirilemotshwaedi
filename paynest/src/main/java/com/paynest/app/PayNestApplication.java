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


/*

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
            System.out.println(""+ item.product.getName() + " x " + item.quantity + " = R" + item.calculateTotal());
            totalOrders = totalOrders+ item.quantity ;
        } 
        System.out.println("-----------------------------------");
        System.out.println("Total Amount For "+totalOrders+" Items: R" + calculateTotalAmount());
        System.out.println("-----------------------------------");
        System.out.println("Thank You For Shopping With Us \n    Go to www.paynest.co.za \n       Tel: 012 559 0509");
    }

}  

*/