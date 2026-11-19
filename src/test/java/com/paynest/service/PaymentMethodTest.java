package com.paynest.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import com.paynest.domain.Customer;
import com.paynest.domain.Order;
import com.paynest.domain.Product;
import com.paynest.payment.*;

import org.junit.jupiter.api.Test;

class PaymentMethodTest {
    @Test
    void checkoutCanUseDifferentPaymentMethods() {

        Customer customer = new Customer(1, "John Doe", "johndoe@example.com");

        Product product = new Product(1, "Laptop", 12000);

        Order cardOrder = new Order(1, customer);
        cardOrder.addItem(product, 1);

        Order walletOrder = new Order(2, customer);
        walletOrder.addItem(product, 1);

        assertTrue(cardOrder.checkout(new CardPayment()));
        assertTrue(walletOrder.checkout(new WalletPayment()));
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

    @Test
    void checkoutFailsWhenPaymentMethodReturnsFalse(){

        Customer customer = new Customer(1, "John Doe", "johndoe@example.com");

        Order order = new Order(1, customer);

        Product product = new Product(1, "Laptop", 12000);

        order.addItem(product, 1);

        PaymentMethod failedPaymentMethod = new FailedPaymentMethod();

        ByteArrayOutputStream output = new ByteArrayOutputStream();

        PrintStream originalOut = System.out;

        System.setOut(new PrintStream(output));

        try (PrintStream capturedOut = new PrintStream(output)) {
            System.setOut(capturedOut);
            assertFalse(order.checkout(failedPaymentMethod));
        } finally {
            System.setOut(originalOut);
        }

        String checkoutOutput = output.toString();
        assertTrue(checkoutOutput.contains("Payment failed via Failed"));
        assertFalse(checkoutOutput.contains("completed successfully"));
    }
}