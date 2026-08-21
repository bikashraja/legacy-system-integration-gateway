package com.bikashraja.legacyservice.controller;

import com.bikashraja.legacyservice.model.Customer;
import com.bikashraja.legacyservice.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class LegacyCustomerControllerTest {

    private final CustomerRepository customerRepository =
            mock(CustomerRepository.class);

    private final LegacyCustomerController controller =
            new LegacyCustomerController(customerRepository);

    @Test
    void getCustomer_existingCustomer_returnsCustomer() {

        Customer customer = new Customer(
                10001,
                "MonkeyD Luffy",
                "ACTIVE",
                new BigDecimal("1000.00")
        );

        when(customerRepository.findById(10001))
                .thenReturn(customer);

        Customer result = controller.getCustomer(10001);

        assertNotNull(result);
        assertEquals(10001, result.getId());
        assertEquals("MonkeyD Luffy", result.getName());
        assertEquals("ACTIVE", result.getStatus());
        assertEquals(
                new BigDecimal("1000.00"),
                result.getBalance()
        );

        verify(customerRepository).findById(10001);
    }

    @Test
    void getCustomer_nonExistingCustomer_throws404() {

        EmptyResultDataAccessException exception =
                mock(EmptyResultDataAccessException.class);

        when(customerRepository.findById(10004))
                .thenThrow(exception);

        ResponseStatusException result =
                assertThrows(
                        ResponseStatusException.class,
                        () -> controller.getCustomer(10004)
                );

        assertEquals(404, result.getStatusCode().value());
        assertEquals(
                "Customer with id 10004 not found",
                result.getReason()
        );

        verify(customerRepository).findById(10004);
    }
}