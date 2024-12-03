package com.iprody.customerservice.controllers;

import com.iprody.customerservice.dto.customer.CustomerDto;
import com.iprody.customerservice.exceptions.ResourceNotFoundException;
import com.iprody.customerservice.services.CustomerService;
import org.openapitools.api.V1CustomerApi;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements V1CustomerApi {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<CustomerDto> createCustomer(CustomerDto customerDto) {
        return new ResponseEntity<>(
                customerService.save(customerDto),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<CustomerDto> getCustomer(Long id) {
        CustomerDto customerDto = customerService
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", id));
        return new ResponseEntity<>(
                customerDto,
                HttpStatus.OK
        );
    }

    @Override
    public ResponseEntity<Void> updateCustomerName(Long id, CustomerDto customerDto) {
        customerService.updateCustomerName(id, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> updateCustomerSurname(Long id, CustomerDto customerDto) {
        customerService.updateCustomerSurname(id, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> updateCustomerEmail(Long id, CustomerDto customerDto) {
        customerService.updateCustomerEmail(id, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> updateCustomerTelegramId(Long id, CustomerDto customerDto) {
        customerService.updateCustomerTelegramId(id, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<Void> updateCustomerCountry(Long id, CustomerDto customerDto) {
        customerService.updateCustomerCountry(id, customerDto);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
