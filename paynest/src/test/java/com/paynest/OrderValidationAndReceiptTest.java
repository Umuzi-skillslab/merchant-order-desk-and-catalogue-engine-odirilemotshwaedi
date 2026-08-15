package com.paynest;

import static org.junit.jupiter.api.Assertions.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.junit.jupiter.api.Test;
import com.paynest.domain.Customer;
import com.paynest.domain.Order;
import com.paynest.domain.OrderItem;
import com.paynest.domain.Product;

class OrderValidationAndReceiptTest {
    //Tests if the total amount rounds the total off to the nearest 2 decimal places
    @Test
    void orderItemCalculateTotalRounding() {
        Product product = new Product(1, "Laptop", 11999.999);
        OrderItem item = new OrderItem(product, 1);

        assertEquals(BigDecimal.valueOf(12000).setScale(2, RoundingMode.HALF_UP), item.calculateTotal());
    }

    //Tests for grand total amount of the order
    @Test
    void orderCalculateTotalAmount() {
        Customer customer = new Customer(1, "Jane Doe", "jane@example.com");
        Order order = new Order(1, customer);

        order.addItem(new Product(1, "Phone", BigDecimal.valueOf(8000)), 2);
        order.addItem(new Product(2, "Tablet", BigDecimal.valueOf(2000)), 1);

        assertEquals(new BigDecimal("18000.00"), order.calculateTotalAmount());
    }

    //validation test for zero quantity
    @Test
    void addItemValidationZeroQuantity() {
        Order order = new Order(1, new Customer(1, "Jane Doe", "jane@example.com"));

        IllegalArgumentException itemError = assertThrows(IllegalArgumentException.class,
            () -> order.addItem(new Product(2, "Tablet", 2000), 0));
        assertEquals("Quantity must be greater than zero", itemError.getMessage());
    }

    //Tests for negative quantities items
    @Test
    void addItemNegativeQuantityTest(){
        Order order = new Order(1, new Customer(1, "Jane Doe", "jane@example.com"));

    IllegalArgumentException negativeItem = assertThrows(IllegalArgumentException.class,
            () -> order.addItem(new Product(2, "X", 10), -5));
    assertEquals("Quantity must be greater than zero", negativeItem.getMessage());
    }

    //Tests of an grand total of 0
    @Test
    void emptyOrderHasZeroTotal() {
        Order order = new Order(1, new Customer(1, "Jane Doe", "jane@example.com"));

        assertEquals(BigDecimal.valueOf(0.00).setScale(2), order.calculateTotalAmount());
        assertTrue(order.getOrderItems().isEmpty());
    }
   
}
