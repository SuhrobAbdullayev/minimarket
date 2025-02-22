package com.minimarket.domain.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Builder
public class CustomerRequestDto {

    @NotBlank(message = "Customer name is required")
    private String name;

    @Email(message = "it should be an email format")
    @NotBlank(message = "Email is required")
    private String email;
}
