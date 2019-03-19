package com.spring.demo.demo.repository;

import com.spring.demo.demo.model.Customer;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends MongoRepository<Customer, String> {
  Optional<Customer> findById (ObjectId id);
  Customer findByFirstName (String firstName);
  List<Customer> findAllByOrderByIdAsc();
  List<Customer> findAllByOrderByIdDesc ();
  boolean existsByFirstName (String firstName);
}