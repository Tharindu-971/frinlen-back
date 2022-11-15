package com.techscroll.frinlen.repository.Common;

import com.techscroll.frinlen.Entity.Common.InvoiceSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceSequenceRepository extends JpaRepository<InvoiceSequence,Long> {
    InvoiceSequence findTopByOrderByIdDesc();
}
