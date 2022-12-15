package com.techscroll.frinlen.repository.Common;

import com.techscroll.frinlen.Entity.Common.ItemCodeSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemCodeSequenceRepository extends JpaRepository<ItemCodeSequence,Long> {
    ItemCodeSequence findTopByOrderByIdDesc();
}
