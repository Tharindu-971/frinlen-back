package com.techscroll.frinlen.dto.invoice.request;

import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Entity.Invoice.InvoiceQuantity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceCreateRequestDto {
    private Long id;
    private String number;
    private Double total;
    private Double subTotal;
    private Double tax;
    private Double discount;
    private Double taxAmount;
    private Double discountAmount;
    private Boolean isApproved;
    private Long approvedBy;
    private String reason;
    private boolean isActive;
    private Customer customer;
    private Set<InvoiceQuantity> invoiceQuantities = new HashSet<>();
    private Set<InventoryInvoiceCreateRequestDto> inventories = new HashSet<>();
}
