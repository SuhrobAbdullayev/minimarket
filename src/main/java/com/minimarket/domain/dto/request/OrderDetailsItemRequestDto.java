package com.minimarket.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class OrderDetailsItemRequestDto {
    @NotBlank(message = "Product id is required")
    private Long productId;
}
