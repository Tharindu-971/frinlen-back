package com.techscroll.frinlen.controllers.Brand;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Service.Brand.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandService brandService;


    @GetMapping("/")
    public ResponseEntity<List<Brand>> getAllBrands()
    {
        return new ResponseEntity( brandService.findAllBrands(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Brand> getBrandById(@RequestParam Long brandId){
        return new ResponseEntity<>(brandService.findBrandById(brandId), HttpStatus.OK) ;
    }
    @PostMapping()
    public ResponseEntity<?> createBrand(@RequestBody Brand brand){
        return new ResponseEntity<>( HttpStatus.OK) ;
    }

    @PutMapping()
    public ResponseEntity<?> updateBrand(@RequestBody Brand brand){
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteBrand(@RequestParam Long brandId){
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
