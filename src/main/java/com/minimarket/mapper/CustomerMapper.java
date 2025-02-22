package com.minimarket.mapper;

import com.minimarket.domain.dto.request.CustomerRequestDto;
import com.minimarket.domain.dto.response.CustomerResponseDto;
import com.minimarket.domain.entity.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @Mapping(target = "firstName", source = "name")
    Customer toEntity(CustomerRequestDto customerRequestDto);

    @Mapping(target = "name", source = "firstName")
    CustomerResponseDto toDto(Customer customer);


    List<CustomerResponseDto> toListDto(List<Customer> customers);
}
