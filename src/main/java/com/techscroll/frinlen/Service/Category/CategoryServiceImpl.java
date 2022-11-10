package com.techscroll.frinlen.Service.Category;


import com.techscroll.frinlen.Entity.Category.Category;
import com.techscroll.frinlen.repository.Category.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<Category> findAllCategory() {
        return categoryRepository.findAll();
    }
    @Override
    public Category findCategoryById(Long categoryId){
        return categoryRepository.findById(categoryId).get();
    }

    @Override
    public void createCategory(Category category){
        Category categorys = categoryRepository.findByName(category.getName());
        if(categorys != null){
            return ;
        }
        Category categoryCreated = categoryRepository.save(category);
    }
    @Override
    public void deleteCategory(Long categoryId){
        Category category = categoryRepository.findById(categoryId).get();
        if(category != null){
            category.isActive(false);
            categoryRepository.save(category);
        }else {
            return ;
        }

    }
    @Override
    public void updateCategory(Category category){
        Category categorys = categoryRepository.findById(category.getId().get());
        if(categorys != null){
            Category categoryCreated = categoryRepository.save(category);
        }
        return ;
    }
}
