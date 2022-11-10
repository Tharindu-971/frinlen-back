package com.techscroll.frinlen.Service.Brand;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.repository.Brand.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService{
    @Autowired
    private BrandRepository brandRepository;
    @Override
    public List<Brand> findAllBrands(){
        return brandRepository.findAll();
    }
    @Override
    public Brand findBrandById(Long brandId){
        return brandRepository.findById(brandId).get();
    }
    @Override
    public void createBrand(Brand brand){
        Brand brands = brandRepository.findByName(brand.getName());
        if(brands != null){
            return ;
        }
        Brand brandCreated = brandRepository.save(brand);
    }
    @Override
    public void deleteBrand(Long brandId){
        Brand brand = brandRepository.findById(brandId).get();
        if(brand != null){
            brand.isActive(false);
            brandRepository.save(brand);
        }else {
            return ;
        }

    }
    @Override
    public void updateBrand(Brand brand){
        Brand brands = brandRepository.findById(brand.getId().get());
        if(brands != null){
            Brand brandCreated = brandRepository.save(brand);
        }
        return ;
    }


}
