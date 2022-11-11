package com.techscroll.frinlen.Entity.Invoice;



import com.techscroll.frinlen.Entity.Customer.Customer;
import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Supplier.Supplier;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
    private Double sub_total;
    private Double tax;
    private Double discount;
    private Double tax_amount;
    private Double discount_amount;
    private Boolean is_approved;
    private String approved_by;
    private String reason;
    private boolean isActive;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Inventory inventory;
    @ManyToOne
    private Supplier supplier;

    public void isActive(boolean b) {
    }
}
