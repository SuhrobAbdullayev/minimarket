package com.minimarket.controller;

import com.minimarket.domain.dto.ResponseDTO;
import com.minimarket.exceptions.CustomersException;
import com.minimarket.exceptions.OrdersException;
import com.minimarket.exceptions.ProductsException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class ExceptionController {
    @ExceptionHandler(ProductsException.class)
    public ResponseEntity<Object> handleProductException(ProductsException productsException) {
        String errorMessage = productsException.getMessage();
        productsException.printStackTrace();
        ResponseDTO<?> responseDTO = ResponseDTO.error(errorMessage, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OrdersException.class)
    public ResponseEntity<Object> handleOrdersException(OrdersException ordersException) {
        String errorMessage = ordersException.getMessage();
        ordersException.printStackTrace();
        ResponseDTO<?> responseDTO = ResponseDTO.error(errorMessage, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(CustomersException.class)
    public ResponseEntity<Object> handleCustomersException(CustomersException customersException) {
        String errorMessage = customersException.getMessage();
        customersException.printStackTrace();
        ResponseDTO<?> responseDTO = ResponseDTO.error(errorMessage, null);
        return new ResponseEntity<>(responseDTO, HttpStatus.BAD_REQUEST);
    }
}
