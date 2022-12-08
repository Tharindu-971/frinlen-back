package com.techscroll.frinlen.Service.Invoice;

import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.dto.invoice.request.InvoiceCreateRequestDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InvoiceService {

    List<Invoice> findAllInvoices();

    Invoice findInvoiceById(Long invoiceId);

    Invoice createInvoice(InvoiceCreateRequestDto invoice);

    void approvedInvoice(Long id,InvoiceCreateRequestDto approveInvoice);

    void deleteInvoice(Long invoiceId);

    void updateInvoice(Invoice invoice);

}
