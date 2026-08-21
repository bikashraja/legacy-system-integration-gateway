package com.bikashraja.legacyservice.repository;

import com.bikashraja.legacyservice.model.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.EmptyResultDataAccessException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CustomerRepositoryTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void findById_existingCustomer_returnsCustomer() {

        Customer result = customerRepository.findById(10001);

        assertNotNull(result);
        assertEquals(10001, result.getId());
        assertEquals("MonkeyD Luffy", result.getName());
        assertEquals("ACTIVE", result.getStatus());
        assertEquals(
                new BigDecimal("1000.00"),
                result.getBalance()
        );
    }

    @Test
    void findById_nonExistingCustomer_throwsException() {

        assertThrows(
                EmptyResultDataAccessException.class,
                () -> customerRepository.findById(99999)
        );
    }
}