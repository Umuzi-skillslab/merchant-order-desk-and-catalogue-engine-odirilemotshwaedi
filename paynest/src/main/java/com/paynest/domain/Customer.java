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
        if(name == null){
            throw new NullPointerException("Customer name cannot be null");
        }
        
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}