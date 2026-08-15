package com.paynest.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

//Product class
public final class Product {
    private final int id;
    private final String name;
    private final BigDecimal price;

    //Constructor with price as type of big decimal
    public Product(int id, String name, BigDecimal price) {
        if (name == null) {
            throw new NullPointerException("Product name cannot be null");
        }
        if (price == null) {
            throw new NullPointerException("Price cannot be null");
        }
        this.id = id;
        this.name = name;
        this.price = price.setScale(2, RoundingMode.HALF_UP);
    }

    //constructor with price as type double
    public Product(int id, String name, double unitPrice) {
        this(id, name, BigDecimal.valueOf(unitPrice));
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
