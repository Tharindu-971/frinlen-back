package com.techscroll.frinlen.Entity.Inventory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.Entity.Invoice.InvoiceQuantity;
import com.techscroll.frinlen.Entity.Whearhouse.Warehouse;
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
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double buyingPrice;
    private Double sellingPrice;
    private Integer quantity;
    private Integer invoiceQty;
    private String reOrderLevel;
    private boolean inStock;
    private String status;
    private boolean isActive;
    private Double unitLiters;
    private Double liters;

    @OneToMany( mappedBy = "inventory",cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JsonIgnore
    private Set<InvoiceQuantity> invoiceQuantities = new HashSet<>();


    @ManyToMany(mappedBy = "inventory")
    @JsonIgnore
    private Set<Warehouse> warehouses = new HashSet<>();


    public void addWarehouse(Warehouse warehouse){
        this.warehouses.add(warehouse);
    }
}
