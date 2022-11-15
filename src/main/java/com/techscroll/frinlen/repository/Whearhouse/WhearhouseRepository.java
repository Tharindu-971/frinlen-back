package com.techscroll.frinlen.repository.Whearhouse;

import com.techscroll.frinlen.Entity.Whearhouse.Warehouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhearhouseRepository extends JpaRepository<Warehouse,Long> {
    Warehouse findByName(String name);

}
