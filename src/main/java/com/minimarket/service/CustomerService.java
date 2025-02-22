package com.minimarket.service;

import com.minimarket.domain.dto.request.CustomerRequestDto;
import com.minimarket.domain.dto.response.CustomerResponseDto;
import com.minimarket.domain.entity.Customer;
import com.minimarket.mapper.CustomerMapper;
import com.minimarket.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public void createCustomer(CustomerRequestDto customerRequestDto){
        if (customerRepository.existsByEmail(customerRequestDto.getEmail())){
            throw new RuntimeException("A user with the email is already exists");
        }

        Customer customer = customerMapper.toEntity(customerRequestDto);

        customerRepository.save(customer);
    }

    public CustomerResponseDto getCustomer(Long id){
        Customer customer = customerRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Customer not exist")
        );
        CustomerResponseDto customerResponseDto = customerMapper.toDto(customer);

        return customerResponseDto;
    }

    public List<CustomerResponseDto> getAll(){
        List<Customer> customers = customerRepository.findAll();
        if (customers.isEmpty()){
            throw new RuntimeException("There are no customers in database");
        }
        List<CustomerResponseDto> customerResponseDtos = customerMapper.toListDto(customers);
        return customerResponseDtos;
    }

}
