package com.techscroll.frinlen.Entity.Inventory;
import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
import com.techscroll.frinlen.Entity.Whearhouse.Whearhouse;
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
    private Double buying_price;
    private Double selling_price;
    private Integer quantity;
    private String reorder_level;
    private boolean instock;
    private String status;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private Set<Invoice> invoice = new HashSet<>();

    @ManyToOne
    private Brand brand;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "inventory")
    private Set<Whearhouse> whearhouse = new HashSet<>();

    public void isActive(boolean b) {
    }
}
