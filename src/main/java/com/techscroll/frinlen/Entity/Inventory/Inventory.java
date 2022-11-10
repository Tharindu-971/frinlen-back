package com.techscroll.frinlen.Entity.Inventory;
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
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double buying_price;
    private Double selling_price;
    private Double quantity;
    private String reorder_level;
    private boolean instock;
    private Double status;
    private boolean isActive;

    public void isActive(boolean b) {
    }
}
