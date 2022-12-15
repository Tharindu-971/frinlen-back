package com.techscroll.frinlen.Entity.Customer;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.techscroll.frinlen.Entity.Agent.Agent;
import com.techscroll.frinlen.Entity.Invoice.Invoice;
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
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String mobile;
    private String email;
    private String vatNo;
    private boolean isActive;
    private String address1;
    private String address2;
    @OneToMany(mappedBy = "customer")
    @JsonIgnore
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
