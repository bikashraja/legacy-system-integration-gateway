package com.bikashraja.gateway.controller;

import com.bikashraja.gateway.model.Customer;
import com.bikashraja.gateway.service.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id) {
        return customerService.getCustomer(id);
    }
}
