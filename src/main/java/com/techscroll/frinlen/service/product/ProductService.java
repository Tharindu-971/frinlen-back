package com.techscroll.frinlen.service.product;

import com.techscroll.frinlen.dto.product.ProductCreateRequestDto;
import com.techscroll.frinlen.dto.product.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<ProductResponseDto> getAllProduct();

    ProductResponseDto createProduct(ProductCreateRequestDto productCreateRequestDto);
}
