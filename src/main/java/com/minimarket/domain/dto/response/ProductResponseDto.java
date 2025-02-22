package com.minimarket.domain.dto.response;

import lombok.Builder;

@Builder
public record ProductResponseDto(
        Long id,
        String name,
        Double price,
        String description
) {
}
