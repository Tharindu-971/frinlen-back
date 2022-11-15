package com.techscroll.frinlen.Entity.Inventory;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.Entity.Whearhouse.Warehouse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double buyingPrice;
    private Double sellingPrice;
    private Integer quantity;
    private String reOrderLevel;
    private boolean inStock;
    private String status;
    private boolean isActive;

    @ManyToMany( mappedBy = "inventories")
    private Set<Invoice> invoices = new HashSet<>();


    @ManyToMany(mappedBy = "inventory")
    private Set<Warehouse> warehouses = new HashSet<>();

    public void addInvoice(Invoice invoice){
        this.invoices.add(invoice);
    }

    public void addWarehouse(Warehouse warehouse){
        this.warehouses.add(warehouse);
    }
}
