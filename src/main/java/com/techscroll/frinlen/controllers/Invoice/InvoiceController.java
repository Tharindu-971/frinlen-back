package com.techscroll.frinlen.controllers.Invoice;

import com.techscroll.frinlen.Entity.Agent.Agent;
import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.Service.Common.InvoiceSequenceService;
import com.techscroll.frinlen.Service.Invoice.InvoiceService;
import com.techscroll.frinlen.dto.invoice.request.AgentCustomerCreateRequestDto;
import com.techscroll.frinlen.repository.Agent.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;

    @Autowired
    private InvoiceSequenceService invoiceSequenceService;

    @Autowired
    private AgentRepository agentRepository;

    @GetMapping("/sequence")
    public ResponseEntity<String> generateInvoiceId(){
        return new ResponseEntity<>(invoiceSequenceService.getInvoiceSequence(),HttpStatus.OK);
    }

    @PostMapping("/agent")
    public ResponseEntity<Agent> agentCustomerCreate(@RequestBody @Valid AgentCustomerCreateRequestDto agentCustomerCreateRequestDto){
        Agent agent = new Agent();
        agent.setName(agentCustomerCreateRequestDto.getAgentName());
        agent.setEmail(agentCustomerCreateRequestDto.getAgentEmail());
        agent.setMobile(agentCustomerCreateRequestDto.getAgentMobile());

        Customer customer = new Customer();
        customer.setName(agentCustomerCreateRequestDto.getName());
        customer.setEmail(agentCustomerCreateRequestDto.getEmail());
        customer.setMobile(agentCustomerCreateRequestDto.getMobile());
        customer.setAddress1(agentCustomerCreateRequestDto.getAddress1());
        customer.setAddress2(agentCustomerCreateRequestDto.getAddress2());


        agent.addCustomer(customer);

        Agent newAgent = agentRepository.save(agent);

        return new ResponseEntity(newAgent,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices()
    {
        return new ResponseEntity( invoiceService.findAllInvoices(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@RequestParam Long invoiceId){
        return new ResponseEntity<>(invoiceService.findInvoiceById(invoiceId), HttpStatus.OK) ;
    }
    @PostMapping
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
