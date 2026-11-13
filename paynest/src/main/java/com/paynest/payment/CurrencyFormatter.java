package com.paynest.payment;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public final class CurrencyFormatter {

    private CurrencyFormatter() {
    }

    public static String format(BigDecimal amount) {
        NumberFormat formatter =
            NumberFormat.getCurrencyInstance(
                Locale.forLanguageTag("en-ZA")
            );

        return formatter.format(amount).replace('\u00A0', ' ');
    }
}