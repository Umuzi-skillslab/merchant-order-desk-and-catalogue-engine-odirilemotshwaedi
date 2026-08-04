package com.paynest.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

//Class order item
public class OrderItem {
        private Product product;
        private int quantity;

        public OrderItem(){
        }
        
        //Constructor
        public OrderItem(Product product, int quantity) {
            if(quantity <= 0){
                throw new IllegalArgumentException("The quantity of products must be greater than 0");
            }
            if(product == null){
                throw new NullPointerException("Product cannot be null");
            }
            this.product = product;
            this.quantity = quantity;
        }
        //Getters and setters
        public Product getProduct() {
            return product;
        }
        public void setProduct(Product product) {
            this.product = product;
        }
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        //Function to calculate the total amount of items per quantity
        public BigDecimal calculateTotal() {
            return  product.getPrice().multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
        }
}