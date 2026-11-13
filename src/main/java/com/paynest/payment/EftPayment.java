package com.paynest.payment;

import java.math.BigDecimal;

/**
 * Handles simulated EFT payments
 * Implements the shared PaymentMethod interface to ensure
 * EFT follows the same payment contract as other methods.
 */

public class EftPayment implements PaymentMethod {

    @Override
    public boolean processPayment(BigDecimal amount){

        // Validate the payment amount.
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        // Process the eft payment.
        System.out.println("Processing EFT payment for "
            + CurrencyFormatter.format(amount));
        return true;
    }

    @Override
    public String getPaymentType(){
        return "EFT";
    }
}
