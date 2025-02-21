package com.minimarket.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderRequestDto {
    private Long customer_id;
    private Long product_id;
}
