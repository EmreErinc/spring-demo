package com.spring.demo.demo.repository;

import com.spring.demo.demo.model.Sale;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by emre on 19.03.2019
 */
public interface SaleRepository extends MongoRepository<Sale, String> {
  Optional<Sale> findById (ObjectId id);
}
