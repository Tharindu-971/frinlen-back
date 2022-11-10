package com.techscroll.frinlen.Service.Customer;

import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Whearhouse.Whearhouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer findCustomerById(Long customerId);

    void createCustomer(Customer customer);

    void deleteCustomer(Long customerId);

    void updateCustomer(Customer customer);
}
