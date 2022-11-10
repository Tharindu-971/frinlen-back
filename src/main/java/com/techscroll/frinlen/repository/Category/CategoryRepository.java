package com.techscroll.frinlen.repository.Category;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
    Category findByName(String name);
}
