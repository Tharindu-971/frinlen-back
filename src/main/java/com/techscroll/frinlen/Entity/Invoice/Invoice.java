package com.techscroll.frinlen.Entity.Invoice;



import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
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
    private Double discount;
    private Double taxAmount;
    private Double discountAmount;
    private Boolean isApproved;
    private String approvedBy;
    private String reason;
    private boolean isActive;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    @JoinTable(
            name = "inventory_invoice",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "invoice_id"))
    private Set<Inventory> inventories;

    public void addInventory(Inventory inventory){
        this.inventories.add(inventory);
    }
}
