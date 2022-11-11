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
public class Whearhouse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String address;
    private boolean isActive;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "whearhouse")
    private Set<Inventory> inventory = new HashSet<>();

    public void isActive(boolean b) {
    }
}

