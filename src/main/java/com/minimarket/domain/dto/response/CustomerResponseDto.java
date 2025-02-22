package com.minimarket.domain.dto.response;

import lombok.Builder;


@Builder
public record CustomerResponseDto(
        Long id,
        String name,
        String email,
        Integer phoneNumber,
        String address
) {
}
