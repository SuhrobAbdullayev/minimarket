package com.minimarket.service;

import com.minimarket.domain.dto.request.CustomerRequestDto;
import com.minimarket.domain.dto.response.CustomerResponseDto;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface CustomersService {

    void createCustomer(CustomerRequestDto dto);

    CustomerResponseDto getCustomerById(Long id);

    List<CustomerResponseDto> getAll(MultiValueMap<String, Object> filter);
}
