package com.paynest.payment;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class PaymentProcessor {

    private static final NumberFormat RAND_FORMATTER = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-ZA"));

    public boolean processPayment(PaymentMethod paymentMethod, BigDecimal amount){

        boolean success = paymentMethod.processPayment(amount);

        if(success) {
            System.out.println("Payment successful via "+ paymentMethod.getPaymentType());
            System.out.println("Amount: " +RAND_FORMATTER.format(amount));
        } else {
            System.out.println("Payment failed via " + paymentMethod.getPaymentType());
        }

        return success;
    }
}
