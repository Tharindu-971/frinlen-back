package com.techscroll.frinlen.repository.Supplier;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,Long> {
    Supplier findByName(String name);
}
