package com.minimarket.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class OrderResponseDto {
    private Long id;
    private CustomerResponceDto customer;
    private Set<ProductResponseDto> products;
}
