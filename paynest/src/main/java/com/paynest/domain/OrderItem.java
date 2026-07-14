package com.paynest.domain;

//Class order item
public class OrderItem {
        private Product product;
        private int quantity;

        //Constructor
        public OrderItem(Product product, int quantity) {
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
        public double calculateTotal() {
            return product.getPrice() * quantity;
        }
    }
