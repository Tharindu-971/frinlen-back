package com.techscroll.frinlen.Entity.Whearhouse;

import com.techscroll.frinlen.Entity.Inventory.Inventory;
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
public class Warehouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String address;
    private boolean isActive;

    @ManyToMany
    @JoinTable(
            name = "inventory_warehouse",
            joinColumns = @JoinColumn(name = "inventory_id"),
            inverseJoinColumns = @JoinColumn(name = "warehouse_id"))
    private Set<Inventory> inventory = new HashSet<>();

    public void isActive(boolean b) {
    }
}

