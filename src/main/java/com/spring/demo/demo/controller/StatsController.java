package com.spring.demo.demo.controller;

import com.spring.demo.demo.model.Stats;
import com.spring.demo.demo.repository.CustomerRepository;
import com.spring.demo.demo.repository.ProductRepository;
import com.spring.demo.demo.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/stats")
public class StatsController {
  private final CustomerRepository customerRepository;
  private final ProductRepository productRepository;
  private final SaleRepository saleRepository;

  @Autowired
  public StatsController(CustomerRepository customerRepository, ProductRepository productRepository, SaleRepository saleRepository) {
    this.customerRepository = customerRepository;
    this.productRepository = productRepository;
    this.saleRepository = saleRepository;
  }

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public Stats getStats() {
    int customerCount = (int) customerRepository.count();
    int productCount = (int) productRepository.count();
    int saleCount = (int) saleRepository.count();

    return Stats.builder()
        .customerCount(customerCount)
        .productCount(productCount)
        .saleCount(saleCount)
        .build();
  }
}
