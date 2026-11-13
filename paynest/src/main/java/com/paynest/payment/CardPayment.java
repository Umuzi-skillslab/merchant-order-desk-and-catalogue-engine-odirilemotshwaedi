package com.paynest.payment;

import java.math.BigDecimal;

/**
 * Handles simulated Card payments
 * Implements the shared PaymentMethod interface to ensure
 * Card follows the same payment contract as other methods.
 */

public class CardPayment implements PaymentMethod {

    @Override
    public boolean processPayment(BigDecimal amount){
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        System.out.println("Processing Card payment for "
            + CurrencyFormatter.format(amount));
        return true;
    }

    @Override
    public String getPaymentType(){
        return "CARD";
    }
}
