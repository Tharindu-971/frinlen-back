package com.techscroll.frinlen.Service.Invoice;

import com.techscroll.frinlen.Entity.Invoice.Invoice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    List<Invoice> findAllInvoices();

    Invoice findInvoiceById(Long invoiceId);

    void createInvoice(Invoice invoice);

    void deleteInvoice(Long invoiceId);

    void updateInvoice(Invoice invoice);

}
