package com.paynest.service;

import java.math.BigDecimal;
import com.paynest.domain.Product;
public class CatalogueService {

    public void addProduct(Product product) {
        //throws and error if a product id is less or equal to 0
        if (product.getId() <= 0) {
            throw new NullPointerException("Product cannot be less than 0");
        }
        //Throws an error if the price of a product is less or equals to 0
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
     }
}
