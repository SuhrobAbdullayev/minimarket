package com.minimarket.domain.dto.response;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class CustomerResponseDto {
    @Id
    private Long id;

    private String name;
}
