package com.bikashraja.legacyservice.model;

import java.math.BigDecimal;

public class Customer {

    private long id;
    private String name;
    private String status;
    private BigDecimal balance;

    public Customer(long id, String name, String status, BigDecimal balance) {
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

    public BigDecimal getBalance() {
        return balance;
    }
}
