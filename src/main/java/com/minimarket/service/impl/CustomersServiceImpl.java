package com.minimarket.service.impl;

import com.minimarket.domain.dto.request.CustomerRequestDto;
import com.minimarket.domain.dto.response.CustomerResponseDto;
import com.minimarket.domain.entity.Customers;
import com.minimarket.exceptions.CustomersException;
import com.minimarket.repository.CustomerRepository;
import com.minimarket.repository.dao.CustomersDao;
import com.minimarket.service.CustomersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CustomersServiceImpl implements CustomersService {
    private final CustomerRepository customerRepository;
    private final CustomersDao customersDao;

    @Override
    public void createCustomer(CustomerRequestDto dto) {
        Customers entity = new Customers();
        entity.setName(dto.getName());
        customerRepository.save(entity);
    }

    @Override
    public CustomerResponseDto getCustomerById(Long id) {
        CustomerResponseDto dto = new CustomerResponseDto();
        Optional<Customers> entity = customerRepository.findById(id);
        if (entity.isPresent()) {
            dto.setId(entity.get().getId());
            dto.setName(entity.get().getName());
            return dto;
        } else {
            throw new CustomersException("The customer is not exists");
        }
    }

    @Override
    public List<CustomerResponseDto> getAll(MultiValueMap<String, Object> filter) {
        List<CustomerResponseDto> dtoList = customersDao.findAll(filter);
        if (!dtoList.isEmpty()) {
            return dtoList;
        } else {
            throw new CustomersException("The customers is empty");
        }
    }
}
