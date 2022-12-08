package com.techscroll.frinlen.repository.Invoice;

import com.techscroll.frinlen.Entity.Invoice.InvoiceQuantity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceQuantityRepository extends JpaRepository<InvoiceQuantity,Long> {
}
