package com.bikashraja.gateway.model;

public class Customer {

    private long id;
    private String name;
    private String status;
    private double balance;

    public Customer(long id, String name, String status, double balance) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.balance = balance;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public double getBalance() {
        return balance;
    }
}
