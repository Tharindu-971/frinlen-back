package com.techscroll.frinlen.controller.product;

import com.techscroll.frinlen.dto.product.ProductCreateRequestDto;
import com.techscroll.frinlen.dto.product.ProductResponseDto;
import com.techscroll.frinlen.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponseDto>> getAllProduct(){
        return  new ResponseEntity<List<ProductResponseDto>>(productService.getAllProduct(), HttpStatus.OK);
    }

    public ResponseEntity<ProductResponseDto> createProduct(@RequestBody ProductCreateRequestDto productCreateRequestDto){
        return new ResponseEntity<ProductResponseDto>(productService.createProduct(productCreateRequestDto),HttpStatus.CREATED);
    }
}
