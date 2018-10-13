package com.spring.demo.demo;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerRepository extends MongoRepository<Customer, String> {
  Customer findById (Integer id);
  Customer findByFirstName (String firstName);
  List<Customer> findAllByOrderByIdAsc();
  List<Customer> findAllByOrderByIdDesc ();
  boolean existsByFirstName (String firstName);
}