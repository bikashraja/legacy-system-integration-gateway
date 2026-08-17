package com.bikashraja.gateway.controller;

import com.bikashraja.gateway.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id) {

        return new Customer(
                id,
                "Bikash Raja",
                "ACTIVE",
                1000
        );
    }
}
