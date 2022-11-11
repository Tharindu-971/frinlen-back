package com.techscroll.frinlen.controllers.Supplier;

import com.techscroll.frinlen.Entity.Supplier.Supplier;
import com.techscroll.frinlen.Service.Supplier.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/")
    public ResponseEntity<List<Supplier>> getAllSuppliers()
    {
        return new ResponseEntity( supplierService.findAllSuppliers(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Supplier> getSupplierById(@RequestParam Long supplierId){
        return new ResponseEntity<>(supplierService.findSupplierById(supplierId), HttpStatus.OK) ;
    }
    @PostMapping()
    public ResponseEntity<?> createSupplier(@RequestBody Supplier supplier){
        return new ResponseEntity<>( HttpStatus.CREATED) ;
    }

    @PutMapping()
    public ResponseEntity<?> updateSupplier(@RequestBody Supplier supplier){
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteSupplier(@RequestParam Long supplierId){
        return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}
