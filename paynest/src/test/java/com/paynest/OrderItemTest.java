package com.paynest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.paynest.domain.OrderItem;
import com.paynest.domain.Product;



class OrderItemTest {
    //Test to check if the total amount of items per quantity is calculated correctly
    @Test
    void checkingMultiplicationAndRounding() {
        Product product = new Product(1, "Laptop", 12000);
        OrderItem orderItem = new OrderItem(product, 2);

        assertEquals(BigDecimal.valueOf(24000.00).setScale(2), orderItem.calculateTotal());
    }
    //Test to check if the quantity of products is greater than 0 when creating an order item
    @Test
    void zeroQuantityTest(){
        Product product = new Product(1, "laptop", 12000);
        assertThrows(IllegalArgumentException.class, () -> new OrderItem(product, 0));
    }

    //Test to check if the product is null when creating an order item
    @Test
    void nullProductTest(){
        assertThrows(NullPointerException.class, () -> new OrderItem(null, 1));
    }
}
