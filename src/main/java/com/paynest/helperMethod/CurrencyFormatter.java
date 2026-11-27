package com.paynest.helperMethod;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class CurrencyFormatter {

    /**
    * Prevents instantiation of this utility class.
    */
    private CurrencyFormatter() {
    }

    //Format an amount as South African currency.
    public static String format(BigDecimal amount) {

        //Create a formatter for South African currency.
        NumberFormat formatter =
            NumberFormat.getCurrencyInstance(
                Locale.forLanguageTag("en-ZA")
            );

        //Replace non-breaking spaces with regular spaces.
        return formatter.format(amount).replace('\u00A0', ' ');
    }
}