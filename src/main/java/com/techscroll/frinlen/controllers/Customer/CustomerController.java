package com.techscroll.frinlen.controllers.Customer;

import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Service.Customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        //meka wenama watune (ResponseEntity<List<Customer>>)
        return (ResponseEntity<List<Customer>>) customerService.findAllCustomers();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerById(@RequestParam Long customerId){
        return customerService.findCustomerById(customerId);
    }
}
