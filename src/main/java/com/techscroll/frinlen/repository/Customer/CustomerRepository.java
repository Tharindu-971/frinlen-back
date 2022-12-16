package com.techscroll.frinlen.repository.Customer;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Customer.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
    Customer findByMobile(String mobile);
    List<Customer> findByMobileContaining(String mobile);
}
