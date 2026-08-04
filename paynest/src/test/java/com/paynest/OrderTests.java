package com.paynest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import com.paynest.domain.Customer;
import com.paynest.domain.Product;
import com.paynest.domain.Order;
import java.text.NumberFormat;

class OrderTests {
    //Test each items total of the order
    @Test
    void lineTotalsAndCurrencyTest(){
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        Order order = new Order(1, new Customer(1, "John Doe", "john.doe@example.com"));

        order.addItem(new Product(2, "Smartphone", 8000), 2);

        assertEquals("R16\u00A0000,00", currencyFormatter.format(order.calculateTotalAmount()));
    }
    //Test to check if the order starts with an empty list of order items
    @Test
    void emptyOrderItemsTest() {
        Order order = new Order(1, new Customer(1, "John  Doe", "john.doe@example.com"));

        assertTrue(order.getOrderItems().isEmpty(),"An order should start with an empty list of order items.");
    }
}
