package com.techscroll.frinlen.Service.Supplier;

import com.techscroll.frinlen.Entity.Supplier.Supplier;
import com.techscroll.frinlen.Entity.Supplier.Supplier;
import com.techscroll.frinlen.Entity.Whearhouse.Whearhouse;
import com.techscroll.frinlen.repository.Supplier.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierRepository supplierRepository;
    @Override
    public List<Supplier> findAllSuppliers(){
        return supplierRepository.findAll();
    }
    @Override
    public Supplier findSupplierById(Long supplierId){
        return supplierRepository.findById(supplierId).get();
    }
    @Override
    public void createSupplier(Supplier supplier){
        Supplier suppliers = supplierRepository.findByName(supplier.getName());
        if(suppliers != null){
            return ;
        }
        Supplier supplierCreated = supplierRepository.save(supplier);
    }
    @Override
    public void deleteSupplier(Long supplierId){
        Supplier supplier = supplierRepository.findById(supplierId).get();
        if(supplier != null){
            supplier.isActive(false);
            supplierRepository.save(supplier);
        }else {
            return ;
        }

    }
    @Override
    public void updateSupplier(Supplier supplier){
        Supplier suppliers = supplierRepository.findById(supplier.getId().get());
        if(suppliers != null){
            Supplier supplierCreated = supplierRepository.save(supplier);
        }
        return ;
    }

}
