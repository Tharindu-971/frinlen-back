package com.techscroll.frinlen.Entity.Category;

import com.techscroll.frinlen.Entity.Brand.Brand;
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
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
    private Set<Brand> brand = new HashSet<>();

    public void isActive(boolean b) {
    }
}
