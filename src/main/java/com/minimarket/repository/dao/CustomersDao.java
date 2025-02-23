package com.minimarket.repository.dao;

import com.minimarket.domain.dto.response.CustomerResponseDto;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface CustomersDao {
    List<CustomerResponseDto> findAll(MultiValueMap<String, Object> filter);
}
