package com.spring.demo.demo.repository;

import com.spring.demo.demo.model.Product;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product, String> {
  Optional<Product> findById (ObjectId id);
  Product findByName (String name);
  List<Product> findAllByOrderByIdAsc();
  boolean existsByName (String name);
}
