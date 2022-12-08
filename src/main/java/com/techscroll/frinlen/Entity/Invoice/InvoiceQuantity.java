package com.techscroll.frinlen.Entity.Invoice;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techscroll.frinlen.Entity.Inventory.Inventory;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class InvoiceQuantity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int invoiceQuantity;
    private int approvedQuantity;
    private boolean status;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "invoice_id")
    @JsonIgnore
    private Invoice invoice;
}
