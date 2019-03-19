package com.spring.demo.demo.controller;

import com.spring.demo.demo.model.Product;
import com.spring.demo.demo.model.ProductRequest;
import com.spring.demo.demo.repository.ProductRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/product")
public class ProductController {
  private final ProductRepository productRepository;

  @Autowired
  public ProductController(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  @RequestMapping(value = "/",method = RequestMethod.GET)
  public List<Product> getAll(){
    return productRepository.findAllByOrderByIdAsc();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Optional<Product> getOne(@PathVariable ObjectId id){
    return productRepository.findById(id);
  }

  @RequestMapping(value = "/",method = RequestMethod.POST)
  public boolean save (@RequestBody ProductRequest request){
    boolean status = false;
    if (!productRepository.existsByName(request.getName())){

      Product product = Product.builder()
          .name(request.getName())
          .build();

      productRepository.save(product);
      status = true;
    }
    return status;
  }

  @RequestMapping(method = RequestMethod.GET)
  public Product getByFirstName (@RequestParam(value = "name") String firstName){
    return productRepository.findByName(firstName);
  }
}
