package com.techscroll.frinlen.service.product;

import com.techscroll.frinlen.dto.product.ProductCreateRequestDto;
import com.techscroll.frinlen.dto.product.ProductResponseDto;
import com.techscroll.frinlen.entity.product.Product;
import com.techscroll.frinlen.mapper.product.ProductMapper;
import com.techscroll.frinlen.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;


    @Override
    public List<ProductResponseDto> getAllProduct() {
        return null;
    }

    @Override
    public ProductResponseDto createProduct(ProductCreateRequestDto productCreateRequestDto) {
        return null;
    }
}
