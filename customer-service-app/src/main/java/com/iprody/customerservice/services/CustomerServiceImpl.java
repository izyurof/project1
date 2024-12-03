package com.iprody.customerservice.services;

import com.iprody.customerservice.dto.customer.CustomerDto;
import com.iprody.customerservice.mappers.CustomerMapper;
import com.iprody.customerservice.models.Customer;
import com.iprody.customerservice.repositories.CustomerRepository;
import com.iprody.customerservice.specifications.CustomerSpecification;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    private final CustomerMapper customerMapper;

    @Override
    public CustomerDto save(CustomerDto customerDto) {
        return Optional
                .ofNullable(customerDto)
                .map(customerMapper::toCustomer)
                .map(customerRepository::saveAndFlush)
                .map(customerMapper::toCustomerDto)
                .orElseThrow(IllegalArgumentException::new);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerDto> findById(Long id) {
        return customerRepository
                .findById(id)
                .map(customerMapper::toCustomerDto);
    }

    @Override
    public void updateCustomerName(Long id, CustomerDto customerDto) {
        customerRepository
                .updateCustomerName(id, customerDto.getName());
    }

    @Override
    public void updateCustomerSurname(Long id, CustomerDto customerDto) {
        customerRepository
                .updateCustomerSurname(id, customerDto.getSurname());
    }

    @Override
    public void updateCustomerEmail(Long id, CustomerDto customerDto) {
        customerRepository
                .updateCustomerEmail(id, customerDto.getContactDetailsDto().getEmail());
    }

    @Override
    public void updateCustomerTelegramId(Long id, CustomerDto customerDto) {
        customerRepository
                .updateCustomerTelegramId(id, customerDto.getContactDetailsDto().getTelegramId());
    }

    @Override
    public void updateCustomerCountry(Long id, CustomerDto customerDto) {
        customerRepository
                .updateCustomerCountry(id, customerDto.getCountryDto().getName());
    }
}
