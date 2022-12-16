package com.techscroll.frinlen.Service.Customer;

import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.dto.customer.request.CustomerCreateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CustomerService {

    List<Customer> findAllCustomers();

    Customer findCustomerById(Long customerId);

    Customer createCustomer(CustomerCreateRequest customer);

    void deleteCustomer(Long customerId);

    void updateCustomer(Customer customer);
}
