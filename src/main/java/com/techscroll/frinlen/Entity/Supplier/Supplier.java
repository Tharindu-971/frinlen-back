package com.techscroll.frinlen.Entity.Supplier;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
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
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
    private String email;
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Set<Invoice> invoice = new HashSet<>();

    public void isActive(boolean b) {
    }
}
