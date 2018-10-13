package controller;

import model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import repository.CustomerRepository;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {
  private final CustomerRepository customerRepository;

  @Autowired
  public CustomerController(CustomerRepository customerRepository) {
    this.customerRepository = customerRepository;
  }

  //localhost:7000/customer/all
  @RequestMapping(value = "/all",method = RequestMethod.GET)
  public List<Customer> getAll(){
    return customerRepository.findAll();
  }

  //localhost:7000/customer/<id>
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Customer getOne(@PathVariable Integer id){
    return customerRepository.findById(id);
  }

  //localhost:7000/customer/
  @RequestMapping(value = "/",method = RequestMethod.POST)
  public boolean save (@RequestBody Customer customer){
    boolean status = false;
    if (!customerRepository.existsByFirstName(customer.getFirstName())){
      customerRepository.save(customer);
      status = true;
    }
    return status;
  }

  //localhost:7000/customer?firstName=<name>
  @RequestMapping(method = RequestMethod.GET)
  public Customer getByFirstName (@RequestParam(value = "firstName") String firstName){
    return customerRepository.findByFirstName(firstName);
  }

  //localhost:7000/customer/orderBy/ASC
  //or
  //localhost:7000/customer/orderBy/DESC
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