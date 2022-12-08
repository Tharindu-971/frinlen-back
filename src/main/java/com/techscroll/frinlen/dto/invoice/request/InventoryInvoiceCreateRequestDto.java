package com.techscroll.frinlen.dto.invoice.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InventoryInvoiceCreateRequestDto {
    private Long id;
    private String name;
    private Double buyingPrice;
    private Double sellingPrice;
    private Integer quantity;
    private Integer invoiceQty;
    private Integer approvedQty;
    private String reOrderLevel;
    private boolean inStock;
    private String status;
    private boolean isActive;
    private Double unitLiters;
    private Double liters;
}
