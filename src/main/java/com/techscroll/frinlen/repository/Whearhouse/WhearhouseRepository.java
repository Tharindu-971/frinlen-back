package com.techscroll.frinlen.repository.Whearhouse;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Whearhouse.Whearhouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WhearhouseRepository extends JpaRepository<Whearhouse,Long> {
    Whearhouse findByName(String name);

}
