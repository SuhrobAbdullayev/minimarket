package com.minimarket.domain.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class DetailsParentDto {
    @NotBlank(message = "Customer id is required")
    private Long customerId;

    @NotBlank(message = "Order id is required")
    private Long orderId;

    List<OrderDetailsItemRequestDto> items;
}
