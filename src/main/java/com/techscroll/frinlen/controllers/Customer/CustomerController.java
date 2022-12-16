package com.techscroll.frinlen.controllers.Customer;

import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Service.Customer.CustomerService;
import com.techscroll.frinlen.dto.customer.request.CustomerCreateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private CustomerService customerService;


    @GetMapping
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        return new ResponseEntity( customerService.findAllCustomers(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@RequestParam Long customerId){
        return new ResponseEntity<>(customerService.findCustomerById(customerId), HttpStatus.OK) ;
    }
    @PostMapping()
    public ResponseEntity<?> createCustomer(@RequestBody CustomerCreateRequest customer){

        return ResponseEntity.status(HttpStatus.CREATED).body( customerService.createCustomer(customer)) ;
    }

    @PutMapping()
    public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteCustomer(@RequestParam Long customerId){
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
