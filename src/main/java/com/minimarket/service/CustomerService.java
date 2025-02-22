package com.minimarket.service;

import com.minimarket.domain.dto.request.CustomerRequestDto;
import com.minimarket.domain.dto.response.CustomerResponseDto;
import com.minimarket.domain.entity.Customer;
import com.minimarket.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;

    public void createUser(CustomerRequestDto customerRequestDto){
        if (customerRepository.existsByEmail(customerRequestDto.getEmail())){
            throw new RuntimeException("A user with the email is already exists");
        }

        Customer customer = Customer.builder()
                .name(customerRequestDto.getName())
                .email(customerRequestDto.getEmail())
                .build();

        customerRepository.save(customer);
    }

    public CustomerResponseDto getCustomer(Long id){
        Optional<Customer> customerBox = customerRepository.findById(id);
        Customer customer = customerBox.orElseThrow(
                () -> new RuntimeException("Customer not exist")
        );
        CustomerResponseDto customerResponseDto = CustomerResponseDto.builder()
                .id(customer.getId())
                .name(customer.getName())
                .build();

        return customerResponseDto;

    }

}
