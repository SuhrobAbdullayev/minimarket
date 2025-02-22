package com.minimarket.controller;

import com.minimarket.domain.dto.request.CustomerRequestDto;
import com.minimarket.domain.dto.response.CustomerResponseDto;

import com.minimarket.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @PostMapping("/user/create")
    public void createUser(@RequestBody CustomerRequestDto customerRequestDto){
        customerService.createUser(customerRequestDto);
    }

}
