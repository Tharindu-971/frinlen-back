package com.techscroll.frinlen.controllers.Invoice;

import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.Service.Invoice.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;


    @GetMapping("/")
    public ResponseEntity<List<Invoice>> getAllInvoices()
    {
        return new ResponseEntity( invoiceService.findAllInvoices(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@RequestParam Long invoiceId){
        return new ResponseEntity<>(invoiceService.findInvoiceById(invoiceId), HttpStatus.OK) ;
    }
    @PostMapping()
    public ResponseEntity<?> createInvoice(@RequestBody Invoice invoice){
        return new ResponseEntity<>( HttpStatus.OK) ;
    }

    @PutMapping()
    public ResponseEntity<?> updateInvoice(@RequestBody Invoice invoice){
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteInvoice(@RequestParam Long invoiceId){
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
