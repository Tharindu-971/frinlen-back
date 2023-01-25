package com.techscroll.frinlen.Service.Invoice;

import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.Entity.Invoice.InvoiceQuantity;
import com.techscroll.frinlen.dto.invoice.request.InventoryInvoiceCreateRequestDto;
import com.techscroll.frinlen.dto.invoice.request.InvoiceCreateRequestDto;
import com.techscroll.frinlen.models.User;
import com.techscroll.frinlen.repository.Inventory.InventoryRepository;
import com.techscroll.frinlen.repository.Invoice.InvoiceQuantityRepository;
import com.techscroll.frinlen.repository.Invoice.InvoiceRepository;
import com.techscroll.frinlen.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class InvoiceServiceImpl implements InvoiceService{
    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private InvoiceQuantityRepository invoiceQuantityRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public List<Invoice> findAllInvoices(){
        return invoiceRepository.findAllByOrderByIdDesc();
    }
    @Override
    public Invoice findInvoiceById(Long invoiceId){
        return invoiceRepository.findById(invoiceId).get();
    }
    @Override
    public Invoice createInvoice(InvoiceCreateRequestDto invoice){
        Invoice invoiceCreated = new Invoice().builder()
                .tax(invoice.getTax())
                .customer(invoice.getCustomer())
                .discount(invoice.getDiscount())
                .isActive(true)
                .discountAmount(invoice.getDiscountAmount())
                .number(invoice.getNumber())
                .subTotal(invoice.getSubTotal())
                .total(invoice.getTotal())
                .reason(invoice.getReason())
                .isApproved(false)
                .createDate(invoice.getCreateDate())
                .updatedDay(invoice.getUpdatedDay())
                .deliveryDate(invoice.getDeliveryDate())
                .totalLiters(invoice.getTotalLiters())
                .approvedBy(0L)
                .status("PENDING")
                .invoiceQuantities(new HashSet<>())
                .build();


        //BeanUtils.copyProperties(invoice,invoiceCreated);

        boolean approved = invoice.getIsApproved();
        if(!approved){
            List<Invoice> invoices = invoiceRepository.findByIsApprovedFalse();

            for(InventoryInvoiceCreateRequestDto inv : invoice.getInventories()){
                Inventory inventory = inventoryRepository.findById(inv.getId()).get();

                InvoiceQuantity invoiceQuantity = new InvoiceQuantity();
                invoiceQuantity.setApprovedQuantity(0);
                invoiceQuantity.setInvoiceQuantity(inv.getInvoiceQty());
                invoiceQuantity.setStatus(false);
                invoiceQuantity.setInventory(inventory);
                invoiceQuantity.setInvoice(invoiceCreated);

                invoiceCreated.addInvoiceQuantity(invoiceQuantity);

            }


//        }else{
//            for(InventoryInvoiceCreateRequestDto inv : invoice.getInventories()){
//                System.out.println("idddddd"+inv.getId());
//                Inventory inventory = inventoryRepository.findById(inv.getId()).get();
//
//                inventory.setInvoiceQty(inventory.getInvoiceQty()+inv.getInvoiceQty());
//
//                Inventory i =inventoryRepository.save(inventory);
//
//            }

            invoiceCreated = invoiceRepository.save(invoiceCreated);
        }
        return  invoiceCreated;
    }

    @Override
    public void approvedInvoice(Long id,InvoiceCreateRequestDto approveInvoice){
        Invoice invoice = invoiceRepository.findById(id).get();

        //total subtotal and tax
        double subTotal= 0;
        double tax = 0;
        double total=0;



        User user = userRepository.findById(approveInvoice.getApprovedBy()).get();
        invoice.setApprovedBy(user.getId());
        invoice.setReason(approveInvoice.getReason());
        invoice.setIsApproved(approveInvoice.getIsApproved());
        invoice.setUpdatedDay(approveInvoice.getUpdatedDay());

        if(approveInvoice.getIsApproved()){
            invoice.setStatus("APPROVED");
        }else {
            invoice.setStatus("REJECTED");
        }
        invoice.setTotalLiters(approveInvoice.getTotalLiters());
//
//
//        List<InvoiceQuantity> invoiceQuantities = invoiceQuantityRepository.findAll();
//
//        Set<InvoiceQuantity> invoiceQuantitiesInv = invoice.getInvoiceQuantities();
//
//        invoiceQuantitiesInv.retainAll(invoiceQuantities);
//
//        System.out.println("Intersection = "+ invoiceQuantitiesInv);
//
//        invoiceQuantitiesInv.stream().forEach(invoiceQuantity -> {
//            approveInvoice.getInvoiceQuantities().stream().filter(inv -> inv.getId() == invoiceQuantity.getId()).forEach(iv->{
//                invoiceQuantity.setApprovedQuantity(iv.getApprovedQuantity());
//            });
//            invoiceQuantity.setStatus(true);
//            System.out.println("invoicecccccccccccccc"+invoiceQuantity.getApprovedQuantity());
//            invoiceQuantityRepository.save(invoiceQuantity);
//        });


        approveInvoice.getInvoiceQuantities().stream().forEach(invoiceQuantity -> {
            System.out.println("invoice approved "+ invoiceQuantity.getApprovedQuantity()+"  id"+invoiceQuantity.getId());
        });

        invoice.getInvoiceQuantities().stream().forEach(invoiceQuantity -> {
            System.out.println("invoice:::: "+invoiceQuantity.getApprovedQuantity()+"  id:::"+invoiceQuantity.getId());
        });

        //convert set to list

        List<InvoiceQuantity> invoiceQuantities = new ArrayList<>(approveInvoice.getInvoiceQuantities());
        List<InvoiceQuantity> invoiceQuantitiesInv = new ArrayList<>(invoice.getInvoiceQuantities());

        for (InvoiceQuantity ivoice: invoiceQuantities) {
            System.out.println("invoicecccccapppppppppppccccccccc"+ivoice.getApprovedQuantity());
            for (InvoiceQuantity inv: invoiceQuantitiesInv) {
                System.out.println("not appr"+inv.getApprovedQuantity()+"Id;;;"+inv.getId());
                System.out.println(" appr"+ivoice.getApprovedQuantity()+"idd::::"+ivoice.getId());
                System.out.println("trueeeee "+(ivoice.getId().equals( inv.getId())));
                if(ivoice.getId().equals( inv.getId())){
                    inv.setApprovedQuantity(ivoice.getApprovedQuantity());
                    System.out.println("invoicecccccccccccccc"+ivoice.getApprovedQuantity());
                    inv.setStatus(true);
                    //subTotal = inv.getInventory().getSellingPrice()* invoiceQuantity.getApprovedQuantity();
                    invoiceQuantityRepository.save(inv);

                }
            }

        }


//        approveInvoice.getInvoiceQuantities().stream().forEach(invoiceQuantity -> {
//            invoice.getInvoiceQuantities().stream().forEach(inv->{
//                if(invoiceQuantity.getId() == inv.getId()){
//                    inv.setApprovedQuantity(invoiceQuantity.getApprovedQuantity());
//                    System.out.println("invoicecccccccccccccc"+invoiceQuantity.getApprovedQuantity());
//                    inv.setStatus(true);
//                    //subTotal = inv.getInventory().getSellingPrice()* invoiceQuantity.getApprovedQuantity();
//                    invoiceQuantityRepository.save(inv);
//                }
//            });
//        });

        //invoiceRepository.save(invoice);
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

    @Override
    public Invoice updateInvoiceById(Long id,InvoiceCreateRequestDto invoiceCreateRequestDto) {
        Invoice invoice = invoiceRepository.findById(id).get();
        if(invoice!=null){
            invoice.setDeliveryDate(invoiceCreateRequestDto.getDeliveryDate());
            System.out.println("Delivery Date "+invoice.getDeliveryDate());
            invoiceRepository.save(invoice);
            return invoice;
        }

        return null;
    }
}
