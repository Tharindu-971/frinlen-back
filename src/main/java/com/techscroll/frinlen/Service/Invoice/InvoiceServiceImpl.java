package com.techscroll.frinlen.Service.Invoice;

import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.repository.Invoice.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;
    @Override
    public List<Invoice> findAllInvoices(){
        return invoiceRepository.findAll();
    }
    @Override
    public Invoice findInvoiceById(Long invoiceId){
        return invoiceRepository.findById(invoiceId).get();
    }
    @Override
    public void createInvoice(Invoice invoice){
        Invoice invoices = invoiceRepository.findByNumber(invoice.getNumber());
        if(invoices != null){
            return ;
        }
        Invoice invoiceCreated = invoiceRepository.save(invoice);
    }
    @Override
    public void deleteInvoice(Long invoiceId){
        Invoice invoice = invoiceRepository.findById(invoiceId).get();
        if(invoice != null){
            invoice.setActive(false);
            invoiceRepository.save(invoice);
        }else {
            return ;
        }

    }
    @Override
    public void updateInvoice(Invoice invoice){
        Invoice invoices = invoiceRepository.findById(invoice.getId()).get();
        if(invoices != null){
            Invoice invoiceCreated = invoiceRepository.save(invoice);
        }
        return ;
    }
}
