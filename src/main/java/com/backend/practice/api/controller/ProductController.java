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
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    /**
     * REST API Endpoint:
     *
     *@Method: getProductsApi
     *@Annotation: @ResponseBody
     *@Mapping: @GetMapping("/api/products")
     *@Return Type: Page<ProductDto>
     *@Description: This method returns a paginated list of products as JSON (or XML) data.
     *The @ResponseBody annotation ensures that the return value is written directly to the HTTP response body.
     */
    @ResponseBody
    @GetMapping("/api/products")
    @Operation(summary = "Load all products")
    public Page<ProductDto> getProductsApi(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    /**
     * View Rendering Endpoint:
     *
     *@Method: getProductsView
     *@Mapping: @GetMapping("/view/products")
     *@Return Type: String
     *@Description: This method adds the list of products to the model and returns the name of the view (view). This view will be resolved by the view resolver (e.g., Thymeleaf, JSP) to generate the HTML response.
     */
    @GetMapping("/view/products")
    @Operation(summary = "Load all products")
    public String getProductsView(Pageable pageable, Model model) {
        model.addAttribute("products", productService.getAllProducts(pageable));
        return "/view/products/allProducts";
    }

    @ResponseBody
    @PostMapping("/create-product")
    @Operation(summary = "Create product")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @ResponseBody
    @GetMapping("/find")
    @Operation(summary = "find product by name")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Product not found"),
    })
    public ProductDto findProduct(@RequestParam String name) throws ProductNotFoundException {
        return productService.getProductByName(name);
    }

    @ResponseBody
    @PostMapping("/update/{id}")
    @Operation(summary = "update product")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "Product not found"),
    })
    public ProductDto updateProduct(@PathVariable Integer id, @RequestBody ProductDto productDto) throws ProductNotFoundException {
        return productService.updateProduct(id, productDto);
    }
}
