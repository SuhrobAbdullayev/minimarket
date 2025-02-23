package com.minimarket.mapper;

import com.minimarket.domain.dto.request.ProductRequestDto;
import com.minimarket.domain.dto.response.ProductResponseDto;
import com.minimarket.domain.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(source = "cost", target = "price")
    Product toProductEntity(ProductRequestDto productRequestDto);


    @Mapping(source = "price", target = "cost")
    ProductResponseDto toProductDto(Product product);

    List<ProductResponseDto> toProductResponceList(List<Product> products);
}
