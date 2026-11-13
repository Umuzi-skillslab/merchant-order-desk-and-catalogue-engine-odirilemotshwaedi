package com.paynest.payment;

import java.math.BigDecimal;

/**
 * Defines a contract for all payment methods.
 * Any payment type must implement these operations.
 */

public interface PaymentMethod {
    
    // Process a payment for the specified amount.
    boolean processPayment(BigDecimal amount);

    // Return the name of the payment method.
    String getPaymentType();
}
