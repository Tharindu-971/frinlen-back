package com.techscroll.frinlen.controllers.Invoice;

import com.techscroll.frinlen.Entity.Agent.Agent;
import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.Service.Common.InvoiceSequenceService;
import com.techscroll.frinlen.Service.Invoice.InvoiceService;
import com.techscroll.frinlen.Service.Invoice.InvoiceServiceImpl;
import com.techscroll.frinlen.dto.invoice.request.AgentCustomerCreateRequestDto;
import com.techscroll.frinlen.dto.invoice.request.InvoiceCreateRequestDto;
import com.techscroll.frinlen.dto.invoice.response.InvoiceApprovedResponseDto;
import com.techscroll.frinlen.dto.invoice.response.InvoiceSequenceResponseDto;
import com.techscroll.frinlen.repository.Agent.AgentRepository;
import com.techscroll.frinlen.repository.Customer.CustomerRepository;
import jdk.nashorn.internal.parser.JSONParser;
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

    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping("/sequence")
    public ResponseEntity<InvoiceSequenceResponseDto> generateInvoiceId(){
        InvoiceSequenceResponseDto invoiceSequenceResponseDto = new InvoiceSequenceResponseDto();
        invoiceSequenceResponseDto.setSequenceId(invoiceSequenceService.getInvoiceSequence());
        return new ResponseEntity<>(invoiceSequenceResponseDto,HttpStatus.OK);
    }

    @PostMapping("/agent")
    public ResponseEntity<Customer> agentCustomerCreate(@RequestBody @Valid AgentCustomerCreateRequestDto agentCustomerCreateRequestDto){
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


        Agent newAgent = agentRepository.save(agent);
        customer.setAgent(newAgent);
        Customer newCustomer = customerRepository.save(customer);

        return new ResponseEntity(newCustomer,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Invoice>> getAllInvoices()
    {
        return new ResponseEntity( invoiceService.findAllInvoices(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id){
        return new ResponseEntity<>(invoiceService.findInvoiceById(id), HttpStatus.OK) ;
    }
    @PostMapping
    public ResponseEntity<?> createInvoice(@RequestBody InvoiceCreateRequestDto invoice){
        return new ResponseEntity<>(invoiceService.createInvoice(invoice), HttpStatus.OK) ;
    }

    @PostMapping("/approve/{id}")
    public ResponseEntity<?> approveInvoice(@PathVariable Long id,@RequestBody InvoiceCreateRequestDto invoiceCreateRequestDto){
        invoiceService.approvedInvoice(id,invoiceCreateRequestDto);
        InvoiceApprovedResponseDto approvedResponseDto = new InvoiceApprovedResponseDto();
        approvedResponseDto.setApproved(invoiceCreateRequestDto.getIsApproved());
        return new ResponseEntity<>(approvedResponseDto,HttpStatus.OK);
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
