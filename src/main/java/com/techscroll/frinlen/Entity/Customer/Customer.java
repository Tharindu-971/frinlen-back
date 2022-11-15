package com.techscroll.frinlen.Entity.Customer;


import com.techscroll.frinlen.Entity.Agent.Agent;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
    private String email;
    private boolean isActive;
    @OneToMany(mappedBy = "customer")
    private Set<Invoice> invoices = new HashSet<>();

    @ManyToOne
    @JoinColumn(name="agent_id", nullable=true)
    private Agent agent;

    public void isActive(boolean b) {
    }

    public void addInvoice(Invoice invoice){
        this.invoices.add(invoice);
    }

}
