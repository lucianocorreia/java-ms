package com.javams.productservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.javams.productservice.model.Product;

public interface ProductRepository extends MongoRepository<Product, String> {

}
