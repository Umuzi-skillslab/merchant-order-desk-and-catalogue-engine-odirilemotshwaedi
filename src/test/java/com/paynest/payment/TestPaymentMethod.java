package com.paynest.payment;

import java.math.BigDecimal;

/**
 * A test implementation of the PaymentMethod interface.
 * Used in unit tests to verify that the correct payment amount
 * is passed to a payment method during checkout.
 */

public class TestPaymentMethod implements PaymentMethod {

    private BigDecimal receivedAmount;

    //Simulates payment processing for testing purposes.
    @Override
    public boolean processPayment(BigDecimal amount) {
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            return false;
        }

        this.receivedAmount = amount;
        return true;
    }


    //Returns the name of this test payment method.
    @Override
    public String getPaymentType() {
        return "TEST";
    }

    //Retrieves the amount received during payment processing.
    public BigDecimal getReceivedAmount() {
        return receivedAmount;
    }
}