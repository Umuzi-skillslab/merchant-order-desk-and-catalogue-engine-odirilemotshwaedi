package com.paynest.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public final class OrderItem {
    private final Product product;
    private final int quantity;

    public OrderItem(Product product, int quantity) {
        if (product == null) {
            throw new NullPointerException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("The quantity of products must be greater than 0");
        }
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public BigDecimal calculateTotal() {
        return product.getPrice().multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
    }
}
