package com.techscroll.frinlen.dto.product;

import com.techscroll.frinlen.entity.product.StockStatus;
import com.techscroll.frinlen.entity.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductResponseDto {

    private Long id;
    private Long code;
    private String name;
    private Double strength;
    private Double unitPrice;
    private Double agentUnitPrice;
    private Boolean inStock;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
    private Double unitLiters;
    private Boolean isActive;
    private User createdBy;
    private User updatedBy;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
