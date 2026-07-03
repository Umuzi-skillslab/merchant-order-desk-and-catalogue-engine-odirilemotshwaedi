//import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Create products
        Product product1 = new Product(1, "Laptop", 15000.00);
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