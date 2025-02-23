package com.minimarket.repository.dao;

import com.minimarket.domain.dto.response.OrderResponseDto;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface OrdersDao {
    List<OrderResponseDto> findAll(MultiValueMap<String, Object> filter);
}
