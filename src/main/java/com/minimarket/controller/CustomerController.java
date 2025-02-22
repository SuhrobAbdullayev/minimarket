package com.minimarket.controller;

import com.minimarket.domain.dto.ResponseDTO;
import com.minimarket.domain.dto.request.CustomerRequestDto;
import com.minimarket.domain.dto.response.CustomerResponseDto;
import com.minimarket.service.CustomersService;
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
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomersService customersService;

    @PostMapping("/create")
    public ResponseDTO<String> createCustomer(@RequestBody CustomerRequestDto dto) {
        customersService.createCustomer(dto);
        return ResponseDTO.ok(null, "The customer is created");
    }

    @GetMapping("/{id}")
    public ResponseDTO<CustomerResponseDto> getCustomer(@PathVariable Long id) {
        return ResponseDTO.ok(customersService.getCustomerById(id), "Muaffaqiyatli");

    }

    @GetMapping("/all")
    public ResponseDTO<List<CustomerResponseDto>> getAllCustomers(
            @RequestParam(required = false) String name
    ) {
        MultiValueMap<String, Object> filter = new LinkedMultiValueMap<>();
        filter.add("name", name);

        return ResponseDTO.ok(customersService.getAll(filter), "Muaffaqiyatli");
    }

}
