package com.techscroll.frinlen.repository.Invoice;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice,Long> {
    Invoice findByNumber(Long number);
}
