package com.bikashraja.legacyservice.controller;

import com.bikashraja.legacyservice.model.Customer;
import com.bikashraja.legacyservice.repository.CustomerRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/legacy/customers")
public class LegacyCustomerController {

    private final CustomerRepository customerRepository;

    public LegacyCustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable long id) {
        try {
            return customerRepository.findById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "Customer with id " + id + " not found"
            );
        }
    }
}