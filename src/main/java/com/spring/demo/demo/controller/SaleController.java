package com.spring.demo.demo.controller;

import com.spring.demo.demo.model.Sale;
import com.spring.demo.demo.model.SaleRequest;
import com.spring.demo.demo.repository.SaleRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sale")
public class SaleController {
  private final SaleRepository saleRepository;

  @Autowired
  public SaleController(SaleRepository saleRepository) {
    this.saleRepository = saleRepository;
  }

  @RequestMapping(method = RequestMethod.POST)
  public Sale saleProduct (@RequestBody SaleRequest request) {
    Sale sale = Sale.builder()
        .userId(request.getUserId())
        .productId(request.getProductId())
        .build();

    return saleRepository.save(sale);
  }

  @RequestMapping(method = RequestMethod.GET)
  public List<Sale> getAll(){
    return saleRepository.findAll();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Optional<Sale> getOne (@PathVariable ObjectId id) {
    return saleRepository.findById(id);
  }
}
