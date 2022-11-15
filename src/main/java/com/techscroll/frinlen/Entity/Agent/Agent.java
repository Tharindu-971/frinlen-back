package com.techscroll.frinlen.Entity.Agent;

import com.techscroll.frinlen.Entity.Customer.Customer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
    private String email;
    @OneToMany(mappedBy="agent")
    private Set<Customer> customers;

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }
}
