package com.bikashraja.gateway.service;

import com.bikashraja.gateway.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    public Customer getCustomer(long id) {
        return new Customer(
                id,
                "Bikash Raja",
                "ACTIVE",
                1000
        );
    }
}
