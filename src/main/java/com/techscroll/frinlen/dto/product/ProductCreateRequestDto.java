package com.techscroll.frinlen.dto.product;

import com.techscroll.frinlen.entity.product.StockStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ProductCreateRequestDto {
    private String name;
    private Double strength;
    private Double unitPrice;
    private Boolean inStock;
    private Integer quantity;
    @Enumerated(EnumType.STRING)
    private StockStatus stockStatus;
    private Double unitLiters;
    private Boolean isActive;

}
