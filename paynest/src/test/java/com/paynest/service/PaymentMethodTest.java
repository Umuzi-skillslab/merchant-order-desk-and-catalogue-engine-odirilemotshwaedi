package com.paynest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import com.paynest.domain.Customer;
import com.paynest.domain.Order;
import com.paynest.domain.Product;
import com.paynest.payment.*;

import org.junit.jupiter.api.Test;

class PaymentMethodTest {
    @Test
    void checkoutCanUseDifferentPaymentMethods() {
        PaymentMethod card = new CardPayment();
        PaymentMethod wallet = new WalletPayment();
        PaymentMethod paypal = new PayPalPayment();

        assertTrue(card.processPayment(BigDecimal.valueOf(12400)));
        assertTrue(wallet.processPayment(BigDecimal.valueOf(12400)));
        assertTrue(paypal.processPayment(BigDecimal.valueOf(12400)));

        assertEquals("CARD", card.getPaymentType());
        assertEquals("WALLET", wallet.getPaymentType());
        assertEquals("PAYPAL", paypal.getPaymentType());
    }

    @Test
    void checkoutPassesCorrectAmountToPaymentMethod(){

        TestPaymentMethod paymentMethod = new TestPaymentMethod();

        Customer customer = new Customer(1, "John Doe", "johndoe@example.com");
        Order order = new Order(1, customer);
        Product product = new Product(1, "Laptop", 12000);

        order.addItem(product, 1);
        order.checkout(paymentMethod);

        assertEquals(order.calculateTotalAmount(), paymentMethod.getReceivedAmount());
    }
}