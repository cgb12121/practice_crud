package com.backend.practice.service.impl;

import com.backend.practice.model.dto.ProductDto;
import com.backend.practice.model.entity.product.entity.Product;
import com.backend.practice.repository.product.ProductRepository;
import com.backend.practice.service.ProductService;
import com.backend.practice.util.exception.ProductNotFoundException;
import com.backend.practice.util.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    private final ProductMapper productMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toEntity(productDto);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    public ProductDto getProductById(Integer id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        return productMapper.toDto(product);
    }

    @Override
    public ProductDto getProductByName(String name) throws ProductNotFoundException {
        Product product = productRepository.findByProductName(name);
        if (product == null) {
            throw new ProductNotFoundException("Product not found with name: " + name);
        }

        return productMapper.toDto(product);
    }

    @Override
    public Page<ProductDto> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(productMapper::toDto);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ProductDto updateProduct(Integer id, ProductDto productDto) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));

        productMapper.updateEntityFromDto(productDto, product);
        return productMapper.toDto(productRepository.save(product));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteProduct(Integer id) throws ProductNotFoundException {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }
}
