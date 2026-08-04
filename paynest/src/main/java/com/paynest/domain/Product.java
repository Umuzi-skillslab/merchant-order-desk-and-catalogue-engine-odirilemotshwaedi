package com.paynest.domain;

import java.math.BigDecimal;

//Product class
public class Product {
    private int id;
    private String name;
    private BigDecimal price;


    // Constructor
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = BigDecimal.valueOf(price);
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
