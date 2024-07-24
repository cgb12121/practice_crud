package com.backend.practice.service;

import com.backend.practice.model.dto.ProductDto;
import com.backend.practice.util.exception.ProductNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface ProductService {
    @Transactional(rollbackFor = Exception.class)
    ProductDto createProduct(ProductDto productDto);

    ProductDto getProductById(Integer id) throws ProductNotFoundException;

    ProductDto getProductByName(String name) throws ProductNotFoundException;

    Page<ProductDto> getAllProducts(Pageable pageable);

    @Transactional(rollbackFor = Exception.class)
    ProductDto updateProduct(Integer id, ProductDto productDto) throws ProductNotFoundException;

    @Transactional(rollbackFor = Exception.class)
    void deleteProduct(Integer id) throws ProductNotFoundException;
}
