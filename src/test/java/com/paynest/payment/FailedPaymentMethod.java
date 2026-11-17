package com.paynest.payment;

import java.math.BigDecimal;

public class FailedPaymentMethod implements PaymentMethod{
    
    @Override 
    public boolean processPayment(BigDecimal amount){
        return false;
    }

    @Override
    public String getPaymentType(){
        return "Failed";
    }
}
