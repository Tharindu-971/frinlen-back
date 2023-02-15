package com.techscroll.frinlen.entity.product;

import com.techscroll.frinlen.entity.user.User;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    @GeneratedValue(generator = "item_code_generator")
    @GenericGenerator(name = "item_code_generator", strategy = "com.techscrolll.pos.sequencegenerator.ProductCodeGenerator")
    private Long code;
    private String name;
    private Double strength;
    private Double unitPrice;
    private Boolean inStock;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
    private Double unitLiters;

    private Boolean isActive;

    @ManyToOne
    @JoinColumn(name = "created_by")
    @CreatedBy
    private User createdBy;

    @ManyToOne
    @JoinColumn(name = "updated_by")
    @LastModifiedBy
    private User updatedBy;


    @CreationTimestamp
    @CreatedDate
    private LocalDateTime createdOn;

    @UpdateTimestamp
    @LastModifiedDate
    private LocalDateTime updatedOn;
}


