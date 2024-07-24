//package com.backend.practice.util.dump.controller;
//
//import com.backend.practice.model.dto.ProductDto;
//import com.backend.practice.service.ProductService;
//import com.backend.practice.util.exception.ProductNotFoundException;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/api/products")
//public class ProductController {
//
//    @Autowired
//    private ProductService productService;
//
//    @PostMapping
//    @Operation(summary = "Create a new product")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Product created successfully",
//                    content = @Content(schema = @Schema(implementation = ProductDto.class))),
//            @ApiResponse(responseCode = "400", description = "Invalid input")
//    })
//    public ResponseEntity<ProductDto> createProduct(
//            @Parameter(description = "Product data", required = true) @RequestBody ProductDto productDto) {
//        ProductDto createdProduct = productService.createProduct(productDto);
//        return ResponseEntity.ok(createdProduct);
//    }
//
//    @GetMapping("/{id}")
//    @Operation(summary = "Get product by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Product retrieved successfully",
//                    content = @Content(schema = @Schema(implementation = ProductDto.class))),
//            @ApiResponse(responseCode = "404", description = "Product not found")
//    })
//    public ResponseEntity<ProductDto> getProductById(
//            @Parameter(description = "Product ID", required = true) @PathVariable Integer id)
//            throws ProductNotFoundException {
//        ProductDto productDto = productService.getProductById(id);
//        return ResponseEntity.ok(productDto);
//    }
//
//    @GetMapping
//    @Operation(summary = "Get all products")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Products retrieved successfully",
//                    content = @Content(schema = @Schema(implementation = Page.class))),
//            @ApiResponse(responseCode = "400", description = "Invalid input")
//    })
//    public ResponseEntity<Page<ProductDto>> getAllProducts(Pageable pageable) {
//        Page<ProductDto> products = productService.getAllProducts(pageable);
//        return ResponseEntity.ok(products);
//    }
//
//    @PutMapping("/{id}")
//    @Operation(summary = "Update a product by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "200", description = "Product updated successfully",
//                    content = @Content(schema = @Schema(implementation = ProductDto.class))),
//            @ApiResponse(responseCode = "404", description = "Product not found")
//    })
//    public ResponseEntity<ProductDto> updateProduct(
//            @Parameter(description = "Product ID", required = true) @PathVariable Integer id,
//            @Parameter(description = "Updated product data", required = true) @RequestBody ProductDto productDto)
//            throws ProductNotFoundException {
//        ProductDto updatedProduct = productService.updateProduct(id, productDto);
//        return ResponseEntity.ok(updatedProduct);
//    }
//
//    @DeleteMapping("/{id}")
//    @Operation(summary = "Delete a product by ID")
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "204", description = "Product deleted successfully"),
//            @ApiResponse(responseCode = "404", description = "Product not found")
//    })
//    public ResponseEntity<Void> deleteProduct(
//            @Parameter(description = "Product ID", required = true) @PathVariable Integer id)
//            throws ProductNotFoundException {
//        productService.deleteProduct(id);
//        return ResponseEntity.noContent().build();
//    }
//}
