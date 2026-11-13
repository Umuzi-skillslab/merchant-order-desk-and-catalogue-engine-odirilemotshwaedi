package com.paynest.payment;

/**
 * Handles payment processing by validating inputs,
 * delegating payment execution to the selected PaymentMethod,
 * and displaying the payment result.
 */

import java.math.BigDecimal;
public class PaymentProcessor {

    /**
     * Processes a payment using the supplied PaymentMethod.
     *
     * @param paymentMethod the payment method implementation to use
     * @param amount the amount to be charged
     * @return true if the payment succeeds; otherwise false
     */

    public boolean processPayment(PaymentMethod paymentMethod, BigDecimal amount){

        //Validate payment details before processing
        if (paymentMethod == null || amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            System.out.println("Invalid payment details.");
            return false;
        }

        //Delegate payment processing to the selected payment method.
        boolean success = paymentMethod.processPayment(amount);

        // Display the outcome of the payment transaction.
        if(success) {
            System.out.println("Payment successful via "+ paymentMethod.getPaymentType());
            System.out.println("Amount: " + CurrencyFormatter.format(amount));
        } else {
            System.out.println("Payment failed via " + paymentMethod.getPaymentType());
        }

        return success;
    }
}
