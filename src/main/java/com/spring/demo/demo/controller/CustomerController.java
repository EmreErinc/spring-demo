package com.spring.demo.demo.controller;

import com.spring.demo.demo.model.Customer;
import com.spring.demo.demo.model.CustomerRequest;
import com.spring.demo.demo.repository.CustomerRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  //localhost:8080/customer/all
  @RequestMapping(method = RequestMethod.GET)
  public List<Customer> getAll(){
    return customerRepository.findAll();
  }

  //localhost:8080/customer/<id>
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Optional<Customer> getOne(@PathVariable ObjectId id){
    return customerRepository.findById(id);
  }

  //localhost:8080/customer/
  @RequestMapping(method = RequestMethod.POST)
  public boolean save (@RequestBody CustomerRequest request){
    boolean status = false;
    if (!customerRepository.existsByFirstName(request.getFirstName())){
      Customer customer = Customer.builder()
          .firstName(request.getFirstName())
          .lastName(request.getLastName())
          .build();
      customerRepository.save(customer);
      status = true;
    }
    return status;
  }

  //localhost:7000/customer?firstName=<name>
  //@RequestMapping(method = RequestMethod.GET,)
  //public Customer getByFirstName (@RequestParam(value = "firstName") String firstName){
  //  return customerRepository.findByFirstName(firstName);
  //}

  //localhost:8080/customer/orderBy/ASC
  //or
  //localhost:8080/customer/orderBy/DESC
  @RequestMapping(value = "/orderBy/{type}", method = RequestMethod.GET)
  public List<Customer> getByOrdered(@PathVariable String type){
    if (type.equals("ASC") || type.equals("asc")){
      return customerRepository.findAllByOrderByIdAsc();
    }
    else if (type.equals("DESC") || type.equals(("desc"))){
      return customerRepository.findAllByOrderByIdDesc();
    }
    else{
      return null;
    }
  }
}