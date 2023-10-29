package org.atcoffeebreak.productservice.controller;

import lombok.RequiredArgsConstructor;
import org.atcoffeebreak.productservice.dto.ProductRequest;
import org.atcoffeebreak.productservice.dto.ProductResponse;
import org.atcoffeebreak.productservice.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }

    @GetMapping
    public List<ProductResponse> findAll() {
        return productService.findAll();
    }
}
