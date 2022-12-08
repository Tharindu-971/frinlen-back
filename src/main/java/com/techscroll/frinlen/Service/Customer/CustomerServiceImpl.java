package com.techscroll.frinlen.Service.Customer;

import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.repository.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
    @Override
    public Customer findCustomerById(Long customerId){
        return customerRepository.findById(customerId).get();
    }
    @Override
    public Customer createCustomer(Customer customer){
        Customer customers = customerRepository.findByName(customer.getName());

        return customerRepository.save(customer);
    }
    @Override
    public void deleteCustomer(Long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        if(customer != null){
            customer.isActive(false);
            customerRepository.save(customer);
        }else {
            return ;
        }

    }
    @Override
    public void updateCustomer(Customer customer){
        Customer customers = customerRepository.findById(customer.getId()).get();
        if(customers != null){
            Customer customerCreated = customerRepository.save(customer);
        }
        return ;
    }
}
