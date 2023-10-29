package org.atcoffeebreak.productservice.repository;

import org.atcoffeebreak.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
}
