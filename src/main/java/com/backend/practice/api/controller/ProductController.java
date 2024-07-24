package com.backend.practice.api.controller;

import com.backend.practice.model.dto.ProductDto;
import com.backend.practice.service.ProductService;
import com.backend.practice.util.exception.ProductNotFoundException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/*")
    @Operation(summary = "Load all products")
    public Page<ProductDto> getProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @PostMapping("/create-product")
    @Operation(summary = "Create product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/find")
    @Operation(summary = "find product by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Product not found"),
    })
    public ProductDto findProduct(@RequestParam String name) throws ProductNotFoundException {
        return productService.getProductByName(name);
    }

    @PostMapping("/update/{id}")
    @Operation(summary = "update product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Product not found"),
    })
    public ProductDto updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) throws ProductNotFoundException {
        return productService.updateProduct(id, productDto);
    }
}
