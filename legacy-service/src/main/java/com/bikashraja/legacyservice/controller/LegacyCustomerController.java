package com.bikashraja.legacyservice.controller;

import com.bikashraja.legacyservice.model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/legacy/customers")
public class LegacyCustomerController {

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id) {

        return new Customer(
                id,
                "Bikash Raja",
                "ACTIVE",
                new BigDecimal("1000.00")
        );
    }
}
