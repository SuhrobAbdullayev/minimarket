package com.minimarket.domain.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerResponseDto {
    private Long id;
    private String name;
    private String email;
}
