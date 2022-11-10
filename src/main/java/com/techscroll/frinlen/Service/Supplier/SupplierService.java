package com.techscroll.frinlen.Service.Supplier;

import com.techscroll.frinlen.Entity.Supplier.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SupplierService {
    List<Supplier> findAllSuppliers();

    Supplier findSupplierById(Long supplierId);

    void createSupplier(Supplier supplier);

    void deleteSupplier(Long supplierId);

    void updateSupplier(Supplier supplier);

}
