package com.techscroll.frinlen.Service.Category;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Category.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> findAllCategory();

    Category findCategoryById(Long categoryId);

    void createCategory(Category category);

    void deleteCategory(Long categoryId);

    void updateCategory(Category category);

}
