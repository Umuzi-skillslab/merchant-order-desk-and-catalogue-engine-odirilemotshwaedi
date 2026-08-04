package com.paynest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import com.paynest.domain.Customer;
import com.paynest.domain.Product;
import com.paynest.domain.Order;
import java.text.NumberFormat;

class OrderTests {
    
    @Test
    void lineTotalsAndCurrencyTest(){
        NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance();
        Customer customer = new Customer(1, "John Doe", "john.doe@example.com");
        Order order = new Order(1, customer);

        order.addItem(new Product(1, "Laptop", 12000), 1);
        order.addItem(new Product(2, "Smartphone", 8000), 2);


        assertEquals("R28\u00A0000,00", currencyFormatter.format(order.calculateTotalAmount()));
    }

    @Test
    void emptyOrderTotalTest() {
        Order order = new Order(1, new Customer(1, "John  Doe", "john.doe@example.com"));

        assertEquals(BigDecimal.ZERO.setScale(2),order.calculateTotalAmount());
    }
}
