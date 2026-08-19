package com.bikashraja.gateway.service;

import com.bikashraja.gateway.client.LegacyCustomerClient;
import com.bikashraja.gateway.model.Customer;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final LegacyCustomerClient legacyCustomerClient;

    public CustomerService(LegacyCustomerClient legacyCustomerClient) {
        this.legacyCustomerClient = legacyCustomerClient;
    }

    public Customer getCustomer(long id) {
        return legacyCustomerClient.getCustomer(id);
    }
}
