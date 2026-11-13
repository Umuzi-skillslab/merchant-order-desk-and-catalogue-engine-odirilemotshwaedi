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

        // Create different payment method implementations.
        PaymentMethod card = new CardPayment();
        PaymentMethod wallet = new WalletPayment();
        PaymentMethod paypal = new PayPalPayment();

        // Verify that each payment method can process a payment.
        assertTrue(card.processPayment(BigDecimal.valueOf(12400)));
        assertTrue(wallet.processPayment(BigDecimal.valueOf(12400)));
        assertTrue(paypal.processPayment(BigDecimal.valueOf(12400)));

        // Verify that each payment method reports the correct type.
        assertEquals("CARD", card.getPaymentType());
        assertEquals("WALLET", wallet.getPaymentType());
        assertEquals("PAYPAL", paypal.getPaymentType());
    }

    @Test
    void checkoutPassesCorrectAmountToPaymentMethod(){

        // Create a test payment method to capture the amount passed.
        TestPaymentMethod paymentMethod = new TestPaymentMethod();

        // Create test data for the order.
        Customer customer = new Customer(1, "John Doe", "johndoe@example.com");
        Order order = new Order(1, customer);
        Product product = new Product(1, "Laptop", 12000);

        // Add a product to the order.
        order.addItem(product, 1);

        // Process checkout using the test payment method.
        order.checkout(paymentMethod);

        // Verify that checkout passes the correct total amount.
        assertEquals(order.calculateTotalAmount(), paymentMethod.getReceivedAmount());
    }
}