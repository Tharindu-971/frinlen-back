package com.techscroll.frinlen.entity.productagent;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Embeddable
public class ProductAgentId implements Serializable {
    private Long productId;
    private Long agentId;

}
