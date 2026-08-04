package com.paynest;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;

import com.paynest.domain.OrderItem;
import com.paynest.domain.Product;



class OrderItemTest {
    @Test
    void checkingMultiplicationAndRounding() {
        Product product = new Product(1, "Laptop", 12000);
        OrderItem orderItem = new OrderItem(product, 2);

        assertEquals(BigDecimal.valueOf(24000.00).setScale(2), orderItem.calculateTotal());
    }

    @Test
    void zeroQuantityTest(){
        Product product = new Product(1, "laptop", 12000);
        assertThrows(IllegalArgumentException.class, () -> new OrderItem(product, 0));
    }
    
    @Test
    void nullProductTest(){
        assertThrows(NullPointerException.class, () -> new OrderItem(null, 1));
    }
}
