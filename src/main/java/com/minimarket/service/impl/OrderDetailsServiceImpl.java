package com.minimarket.service.impl;

import com.minimarket.domain.dto.request.DetailsParentDto;
import com.minimarket.domain.dto.request.OrderDetailsItemRequestDto;
import com.minimarket.domain.entity.OrderDetails;
import com.minimarket.repository.OrderDetailsRepository;
import com.minimarket.service.OrderDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDetailsServiceImpl implements OrderDetailsService {
    private final OrderDetailsRepository orderDetailsRepository;

    @Override
    public void createDetails(DetailsParentDto dto) {
        for (OrderDetailsItemRequestDto item : dto.getItems()) {
            OrderDetails orderDetails = new OrderDetails();
            orderDetails.setCustomerId(dto.getCustomerId());
            orderDetails.setOrderId(dto.getOrderId());
            orderDetails.setProductId(item.getProductId());
            orderDetailsRepository.save(orderDetails);
        }
    }
}
