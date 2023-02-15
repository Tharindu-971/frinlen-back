package com.techscroll.frinlen.repository.productagent;

import com.techscroll.frinlen.entity.product.Product;
import com.techscroll.frinlen.entity.productagent.ProductAgent;
import com.techscroll.frinlen.entity.productagent.ProductAgentId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductAgentRepository extends JpaRepository<ProductAgent, ProductAgentId> {
    List<ProductAgent> findByAgentIdAndProductIdIn(Long agentId, List<Long> productIds);
    List<ProductAgent> findByProduct(Product product);
}
