package com.minimarket.service;

import com.minimarket.domain.dto.request.OrderRequestDto;
import com.minimarket.domain.dto.response.OrderResponseDto;
import org.springframework.util.MultiValueMap;

import java.util.List;

public interface OrdersService {

    Long createOrder(OrderRequestDto dto);

    OrderResponseDto getByCustomerId(Long id);

    List<OrderResponseDto> getAll(MultiValueMap<String, Object> filter);
}
