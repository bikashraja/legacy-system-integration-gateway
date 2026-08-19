package com.bikashraja.gateway.client;

import com.bikashraja.gateway.model.Customer;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class LegacyCustomerClient {

    public final RestClient restClient;

    public LegacyCustomerClient(RestClient restClient) {
        this.restClient = restClient;
    }

    public Customer getCustomer(long id) {
        return restClient
                .get()
                .uri("/legacy/customers/{id}", id)
                .retrieve()
                .body(Customer.class);
    }
}
