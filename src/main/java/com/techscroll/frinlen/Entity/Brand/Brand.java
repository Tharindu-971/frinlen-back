package com.techscroll.frinlen.Entity.Brand;
import com.techscroll.frinlen.Entity.Category.Category;
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
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean isActive;
    @ManyToOne
    private Category category;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Set<Inventory> stocks = new HashSet<>();

    public void isActive(boolean b) {
    }
}
