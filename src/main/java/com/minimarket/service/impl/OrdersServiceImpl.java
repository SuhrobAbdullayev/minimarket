package com.minimarket.service.impl;

import com.minimarket.domain.dto.request.OrderRequestDto;
import com.minimarket.domain.dto.response.OrderResponseDto;
import com.minimarket.domain.entity.Orders;
import com.minimarket.repository.OrdersRepository;
import com.minimarket.repository.dao.OrdersDao;
import com.minimarket.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdersServiceImpl implements OrdersService {
    private final OrdersRepository ordersRepository;
    private final OrdersDao ordersDao;

    @Override
    public Long createOrder(OrderRequestDto dto) {
        Orders orders = new Orders();
        orders.setCustomerId(dto.getCustomerId());
        orders.setStatus(Boolean.TRUE);
        return ordersRepository.save(orders).getId();
    }

    @Override
    public OrderResponseDto getByCustomerId(Long id) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        Orders orders = ordersRepository.findAllByCustomerId(id);
        orderResponseDto.setId(orders.getId());
        orderResponseDto.setCustomerId(orders.getCustomerId());
        orderResponseDto.setStatus(orders.getStatus());
        return orderResponseDto;
    }

    @Override
    public List<OrderResponseDto> getAll(MultiValueMap<String, Object> filter) {
        return ordersDao.findAll(filter);
    }
}
