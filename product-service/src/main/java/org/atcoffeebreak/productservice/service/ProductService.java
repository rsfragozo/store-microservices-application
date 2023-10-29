package org.atcoffeebreak.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.atcoffeebreak.productservice.dto.ProductRequest;
import org.atcoffeebreak.productservice.dto.ProductResponse;
import org.atcoffeebreak.productservice.helpers.ProductMapper;
import org.atcoffeebreak.productservice.model.Product;
import org.atcoffeebreak.productservice.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    private final ProductRepository productRepository;
    public void createProduct(ProductRequest productRequest) {
        Product product = ProductMapper.mapToProduct(productRequest);
        productRepository.save(product);
        log.info("Product {} is saved", product);
    }

    public List<ProductResponse> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(ProductMapper::mapToProductResponse)
                .toList();
    }
}
