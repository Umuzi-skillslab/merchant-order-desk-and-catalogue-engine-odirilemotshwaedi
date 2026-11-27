package com.paynest.domain;

//Customer class
public class Customer {
    private int id;
    private String name;
    private String email;

    // Constructor
    public Customer(int id, String name, String email) {
        //throws and error if customer id is less than or equal to 0
        if(id <= 0){
            throw new IllegalArgumentException("Customer Id must be greater than 0");
        }
        //Throws an error if customer name is null
        if(name == null || name.isBlank()){
            throw new IllegalArgumentException("Customer name cannot be blank");
        }
        if(email == null || email.isBlank()){
            throw new IllegalArgumentException("Customer email cannot be blank");
        }
        
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
}