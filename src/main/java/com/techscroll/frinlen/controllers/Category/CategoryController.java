package com.techscroll.frinlen.controllers.Category;

import com.techscroll.frinlen.Entity.Category.Category;
import com.techscroll.frinlen.Service.Category.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;


    @GetMapping("/")
    public ResponseEntity<List<Category>> getAllCategorys()
    {
        return new ResponseEntity( categoryService.findAllCategory(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@RequestParam Long categoryId){
        return new ResponseEntity<>(categoryService.findCategoryById(categoryId), HttpStatus.OK) ;
    }
    @PostMapping()
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        return new ResponseEntity<>( HttpStatus.OK) ;
    }

    @PutMapping()
    public ResponseEntity<?> updateCategory(@RequestBody Category category){
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteCategory(@RequestParam Long categoryId){
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
