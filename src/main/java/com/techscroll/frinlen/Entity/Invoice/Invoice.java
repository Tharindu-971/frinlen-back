package com.techscroll.frinlen.Entity.Invoice;



import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Supplier.Supplier;
import com.techscroll.frinlen.models.User;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String number;
    private Double total;
    private Double subTotal;
    private Double tax;
    private Double totalLiters;
    private Double discount;
    private Double taxAmount;
    private Double discountAmount;
    private Boolean isApproved;
    private Long approvedBy;
    private String reason;
    private boolean isActive;

    @ManyToOne
    private Customer customer;

    @OneToMany(fetch = FetchType.EAGER,cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    },mappedBy = "invoice")

    private Set<InvoiceQuantity> invoiceQuantities = new HashSet<>();

    public void addInvoiceQuantity(InvoiceQuantity invoiceQuantity){
        this.invoiceQuantities.add(invoiceQuantity);
    }
}
