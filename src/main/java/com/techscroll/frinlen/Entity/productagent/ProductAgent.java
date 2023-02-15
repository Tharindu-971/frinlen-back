package com.techscroll.frinlen.entity.productagent;

import com.techscroll.frinlen.entity.agent.Agent;
import com.techscroll.frinlen.entity.product.Product;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ProductAgent {
    @EmbeddedId
    private ProductAgentId id;

    private Double price;

    @ManyToOne
    @MapsId("productId")
    private Product product;

    @ManyToOne
    @MapsId("agentId")
    private Agent agent;
}
