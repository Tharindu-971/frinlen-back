package com.techscroll.frinlen.Service.Inventory;

import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Whearhouse.Whearhouse;
import com.techscroll.frinlen.repository.Inventory.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    private InventoryRepository inventoryRepository;
    @Override
    public List<Inventory> findAllInventories(){
        return inventoryRepository.findAll();
    }
    @Override
    public Inventory findInventoryById(Long inventoryId){
        return inventoryRepository.findById(inventoryId).get();
    }

    @Override
    public void createInventory(Inventory inventory){
        Inventory inventorys = inventoryRepository.findByName(inventory.getName());
        if(inventorys != null){
            return ;
        }
        Inventory inventoryCreated = inventoryRepository.save(inventory);
    }
    @Override
    public void deleteInventory(Long inventoryId){
        Inventory inventory = inventoryRepository.findById(inventoryId).get();
        if(inventory != null){
            inventory.isActive(false);
            inventoryRepository.save(inventory);
        }else {
            return ;
        }

    }
    @Override
    public void updateInventory(Inventory inventory){
        Inventory inventorys = inventoryRepository.findById(inventory.getId().get());
        if(inventorys != null){
            Inventory inventoryCreated = inventoryRepository.save(inventory);
        }
        return ;
    }
}
