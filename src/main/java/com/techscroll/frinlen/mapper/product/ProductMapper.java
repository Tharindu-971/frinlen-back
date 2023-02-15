package com.techscroll.frinlen.mapper.product;

import com.techscroll.frinlen.dto.product.ProductResponseDto;
import com.techscroll.frinlen.entity.product.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductResponseDto productToProductResponseDto(Product product);

}
