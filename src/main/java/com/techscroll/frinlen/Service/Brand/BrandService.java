package com.techscroll.frinlen.Service.Brand;

import com.techscroll.frinlen.Entity.Brand.Brand;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BrandService {
    List<Brand> findAllBrands();

    Brand findBrandById(Long brandId);

    void createBrand(Brand brand);

    void deleteBrand(Long brandId);

    void updateBrand(Brand brand);

}
