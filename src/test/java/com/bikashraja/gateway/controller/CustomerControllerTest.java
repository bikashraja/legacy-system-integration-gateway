package com.bikashraja.gateway.controller;

import com.bikashraja.gateway.model.Customer;
import com.bikashraja.gateway.service.CustomerService;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CustomerControllerTest {

    private final CustomerService customerService =
            mock(CustomerService.class);

    private final CustomerController controller =
            new CustomerController(customerService);

    @Test
    void getCustomer_existingCustomer_returnsCustomer() {

        Customer customer = new Customer(
                10001,
                "MonkeyD Luffy",
                "ACTIVE",
                1000
        );

        when(customerService.getCustomer(10001))
                .thenReturn(customer);

        Customer result = controller.getCustomer(10001);

        assertNotNull(result);
        assertEquals(10001, result.getId());
        assertEquals("MonkeyD Luffy", result.getName());
        assertEquals("ACTIVE", result.getStatus());
        assertEquals(1000, result.getBalance());

        verify(customerService).getCustomer(10001);
    }

    @Test
    void getCustomer_nonExistingCustomer_throws404() {

        HttpClientErrorException.NotFound exception =
                mock(HttpClientErrorException.NotFound.class);

        when(customerService.getCustomer(10004))
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

        verify(customerService).getCustomer(10004);
    }
}