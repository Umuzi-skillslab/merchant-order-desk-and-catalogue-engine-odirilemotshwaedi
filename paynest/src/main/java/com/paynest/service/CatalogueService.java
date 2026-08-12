package com.paynest.service;

import java.math.BigDecimal;

import com.paynest.domain.Product;

public class CatalogueService {

    public void addProduct(Product product) {
        if (product.getId() == 0) {
            throw new NullPointerException("Product cannot be less than 0");
        }
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
     }
}
