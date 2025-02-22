package com.minimarket.domain.dto.response;

import lombok.Builder;

import java.util.Set;

@Builder
public record OrderResponseDto(
        Long id,
        CustomerResponseDto customer,
        Set<ProductResponseDto> products
) {
}
