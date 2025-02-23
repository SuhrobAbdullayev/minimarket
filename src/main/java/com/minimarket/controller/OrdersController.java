package com.minimarket.controller;

import com.minimarket.domain.dto.ResponseDTO;
import com.minimarket.domain.dto.request.OrderRequestDto;
import com.minimarket.domain.dto.response.OrderResponseDto;
import com.minimarket.service.OrdersService;
import lombok.RequiredArgsConstructor;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrdersController {
    private final OrdersService ordersService;

    @PostMapping("/create")
    public ResponseDTO<Long> createOrder(@RequestBody OrderRequestDto dto) {
        return ResponseDTO.ok(ordersService.createOrder(dto), "The order is created");
    }

    @GetMapping("/{id}")
    public ResponseDTO<OrderResponseDto> getOrder(@PathVariable Long id) {
        return ResponseDTO.ok(ordersService.getByCustomerId(id), "Muaffaqiyatli");

    }

    @GetMapping("/all")
    public ResponseDTO<List<OrderResponseDto>> getAllOrders(
            @RequestParam(required = false) Long customerId
    ) {
        MultiValueMap<String, Object> filter = new LinkedMultiValueMap<>();
        filter.add("customerId", customerId);

        return ResponseDTO.ok(ordersService.getAll(filter), "Muaffaqiyatli");
    }

}
