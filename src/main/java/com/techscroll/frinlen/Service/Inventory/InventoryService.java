package com.techscroll.frinlen.Service.Inventory;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Entity.Whearhouse.Whearhouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface InventoryService {
    List<Inventory> findAllInventories();

    Inventory findInventoryById(Long inventoryId);

    void createInventory(Inventory inventory);

    void deleteInventory(Long inventoryId);

    void updateInventory(Inventory inventory);

}
