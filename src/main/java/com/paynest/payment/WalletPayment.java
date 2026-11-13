package com.paynest.payment;

import java.math.BigDecimal;

/**
 * Handles simulated wallet payments
 * Implements the shared PaymentMethod interface to ensure
 * Wallet payments follows the same payment contract as other methods.
 */

public class WalletPayment implements PaymentMethod {

    @Override
    public boolean processPayment(BigDecimal amount){

        // Validate the payment amount.
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        // Process the wallet payment.
        System.out.println("Processing Wallet payment for "
            + CurrencyFormatter.format(amount));
        return true;
    }

    @Override
    public String getPaymentType(){
        return "WALLET";
    }
}
