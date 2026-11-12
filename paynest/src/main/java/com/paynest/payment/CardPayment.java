package com.paynest.payment;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

/**
 * Payment done via credit or debit card
 * Card payment implements the shared PaymentMethod
 */

public class CardPayment implements PaymentMethod {

    private static final NumberFormat RAND_FORMATTER = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("en-ZA"));

    @Override
    public boolean processPayment(BigDecimal amount){
        if(amount == null || amount.compareTo(BigDecimal.ZERO) <= 0){
            return false;
        }

        System.out.println("Processing Card payment for "
            + RAND_FORMATTER.format(amount).replace('\u00A0', ' ')); 
        return true;
    }

    @Override
    public String getPaymentType(){
        return "CARD";
    }
}
