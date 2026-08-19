package com.bikashraja.legacyservice.controller;

import com.bikashraja.legacyservice.model.Customer;
import com.bikashraja.legacyservice.repository.CustomerRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/legacy/customers")
public class LegacyCustomerController {

    private final CustomerRepository customerRepository;

    public LegacyCustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerRepository.findById(id);
    }
}