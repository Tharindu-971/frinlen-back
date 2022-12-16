package com.techscroll.frinlen.Service.Customer;

import com.techscroll.frinlen.Entity.Agent.Agent;
import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.dto.customer.request.CustomerCreateRequest;
import com.techscroll.frinlen.repository.Agent.AgentRepository;
import com.techscroll.frinlen.repository.Customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AgentRepository agentRepository;
    @Override
    public List<Customer> findAllCustomers(){
        return customerRepository.findAll();
    }
    @Override
    public Customer findCustomerById(Long customerId){
        return customerRepository.findById(customerId).get();
    }
    @Override
    public Customer createCustomer(CustomerCreateRequest customer){
        Customer customers = customerRepository.findByMobile(customer.getMobile());
        Agent agent = agentRepository.findById(customer.getAgentId()).get();
        Customer cus = new Customer().builder()
                .name(customer.getName())
                .email(customer.getEmail())
                .vatNo(customer.getVatNo())
                .mobile(customer.getMobile())
                .address1(customer.getAddress1())
                .address2(customer.getAddress2())
                .agent(agent)
                .build();
        return customerRepository.save(cus);
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
