package com.paynest.service;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.paynest.domain.Product;

//CatalogueService manages an in-memory product catalogue with efficient lookups.
//Provides methods for adding, retrieving, and managing products.
 
public class CatalogueService {
    private final Map<Integer, Product> productCatalogue;
    private final Map<String, Product> productsByName;

    public CatalogueService() {
        this.productCatalogue = new HashMap<>();
        this.productsByName = new HashMap<>();
    }

    //method to validate product and add it to the catalogue.
    public void addProduct(Product product) {
        if (product == null) {
            throw new NullPointerException("Product cannot be null");
        }
        
        //throws an error if a product id is less or equal to 0
        if (product.getId() <= 0) {
            throw new NullPointerException("Product id cannot be less than or equal to 0");
        }
        
        //Throws an error if the price of a product is less or equals to 0
        if (product.getPrice().compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Price must be greater than zero");
        }
        
        //Throws an error if product already exists
        if (productCatalogue.containsKey(product.getId())) {
            throw new IllegalArgumentException("Product with id " + product.getId() + " already exists");
        }
        
        productCatalogue.put(product.getId(), product);
        productsByName.put(product.getName(), product);
    }

    //Retrieves a product by its id if it exits 
    public Optional<Product> getProductById(int productId) {
        return Optional.ofNullable(productCatalogue.get(productId));
    }

    //Retrieves a product by its name if it exists
    public Optional<Product> getProductByName(String productName) {
        if (productName == null) {
            return Optional.empty();
        }
        return Optional.ofNullable(productsByName.get(productName));
    }

    //Checks if a product exists in the catalogue by id.
    public boolean productExists(int productId) {
        return productCatalogue.containsKey(productId);
    }

    //Returns all products in the catalogue as an unmodifiable map.
    public Map<Integer, Product> getAllProducts() {
        return Collections.unmodifiableMap(new HashMap<>(productCatalogue));
    }

    //Removes a product from the catalogue by id.
    public Optional<Product> removeProduct(int productId) {
        Product removed = productCatalogue.remove(productId);
        if (removed != null) {
            productsByName.remove(removed.getName());
        }
        return Optional.ofNullable(removed);
    }

    //Clears all products from the catalogue.
    public void clearCatalogue() {
        productCatalogue.clear();
        productsByName.clear();
    }
}
