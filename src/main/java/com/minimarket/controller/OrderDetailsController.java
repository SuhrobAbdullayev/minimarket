package com.minimarket.controller;

import com.minimarket.domain.dto.ResponseDTO;
import com.minimarket.domain.dto.request.DetailsParentDto;
import com.minimarket.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order-details")
@RequiredArgsConstructor
public class OrderDetailsController {
    private final OrderDetailsService orderDetailsService;

    @PostMapping("/create")
    public ResponseDTO<?> createOrderDetails(@RequestBody DetailsParentDto dto) {
        orderDetailsService.createDetails(dto);
        return ResponseDTO.ok(null, "The orderDetails is created");
    }

}
