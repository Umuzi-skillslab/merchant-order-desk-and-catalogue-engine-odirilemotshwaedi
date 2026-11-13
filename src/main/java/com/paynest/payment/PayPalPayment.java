package com.paynest.payment;

import java.math.BigDecimal;

/**
 * Handles simulated PayPal payments
 * Implements the shared PaymentMethod interface to ensure
 * PayPal follows the same payment contract as other methods.
 */

public class PayPalPayment implements PaymentMethod{

    @Override
    public boolean processPayment(BigDecimal amount){

        // Validate the payment amount.
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        // Processing a PayPal payment.
        System.out.println("Processing PayPal payment for "
            + CurrencyFormatter.format(amount));
        return true;
    }

    @Override
    public String getPaymentType(){
        return "PAYPAL";
    }
}
