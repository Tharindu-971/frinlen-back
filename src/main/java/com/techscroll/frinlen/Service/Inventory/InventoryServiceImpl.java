package com.techscroll.frinlen.Service.Inventory;

import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Invoice.InvoiceQuantity;
import com.techscroll.frinlen.repository.Inventory.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Iterator;
import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public List<Inventory> findAllInventories(){

        List<Inventory> inventories = inventoryRepository.findAll();

        for(Inventory inv : inventories){
            Iterator<InvoiceQuantity> iterator= inv.getInvoiceQuantities().iterator();

            while (iterator.hasNext()){
                InvoiceQuantity qty = iterator.next();
                if(!qty.isStatus()){
                    inv.setQuantity(inv.getQuantity()-qty.getInvoiceQuantity());
                }
            }
        }
        return inventories;
    }
    @Override
    public Inventory findInventoryById(Long inventoryId){
        return inventoryRepository.findById(inventoryId).get();
    }

    @Override
    public Inventory createInventory(Inventory inventory){
        Inventory inventorys = inventoryRepository.findByName(inventory.getName());
       return inventoryRepository.save(inventory);
    }
    @Override
    public void deleteInventory(Long inventoryId){
        Inventory inventory = inventoryRepository.findById(inventoryId).get();
        if(inventory != null){
            inventory.setActive(false);
            inventoryRepository.save(inventory);
        }else {
            return ;
        }

    }
    @Override
    public void updateInventory(Inventory inventory){
        Inventory inventorys = inventoryRepository.findById(inventory.getId()).get();
        if(inventorys != null){
            Inventory inventoryCreated = inventoryRepository.save(inventory);
        }
        return ;
    }
}
