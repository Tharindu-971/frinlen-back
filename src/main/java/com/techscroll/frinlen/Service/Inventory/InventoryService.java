package com.techscroll.frinlen.Service.Inventory;

import com.techscroll.frinlen.Entity.Inventory.Inventory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<Inventory> findAllInventories();

    Inventory findInventoryById(Long inventoryId);

    Inventory createInventory(Inventory inventory);

    void deleteInventory(Long inventoryId);

    Inventory updateInventory(Long id,Inventory inventory);

}
