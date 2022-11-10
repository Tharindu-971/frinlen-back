package com.techscroll.frinlen.Entity.Invoice;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long number;
    private Double total;
    private Double sub_total;
    private Double tax;
    private Double discount;
    private Double tax_amount;
    private Double discount_amount;
    private Double is_approved;
    private Boolean approved_by;
//    private Double request;
    private boolean isActive;

    public void isActive(boolean b) {
    }
}
