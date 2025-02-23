package com.minimarket.service;

import com.minimarket.domain.dto.request.ProductRequestDto;
import com.minimarket.domain.dto.response.ProductResponseDto;
import com.minimarket.domain.entity.Product;
import com.minimarket.mapper.ProductMapper;
import com.minimarket.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public void createProduct(ProductRequestDto productRequestDto){
        if (productRepository.existsByName(productRequestDto.getName())){
            throw new RuntimeException("A product with the name is already exist");
        }

        productRepository.save(productMapper.toProductEntity(productRequestDto));

    }

    public ProductResponseDto getProduct(Long id){
        Product product = productRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Product with the id is not found")
        );

        return productMapper.toProductDto(product);
    }


    public List<ProductResponseDto> getAllProducts(){
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()){
            throw new RuntimeException("There is no product in database");
        }

        return productMapper.toProductResponceList(products);
    }
}
