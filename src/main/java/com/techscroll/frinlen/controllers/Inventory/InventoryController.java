package com.techscroll.frinlen.controllers.Inventory;

import com.techscroll.frinlen.Entity.Common.ItemCodeSequence;
import com.techscroll.frinlen.Entity.Inventory.Inventory;
import com.techscroll.frinlen.Service.Common.ItemCodeSequenceService;
import com.techscroll.frinlen.Service.Inventory.InventoryService;
import com.techscroll.frinlen.repository.Common.ItemCodeSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ItemCodeSequenceService itemCodeSequenceService;


    @GetMapping
    public ResponseEntity<List<Inventory>> getAllInventories()
    {
        return new ResponseEntity( inventoryService.findAllInventories(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Inventory> getInventoryById(@RequestParam Long inventoryId){
        return new ResponseEntity<>(inventoryService.findInventoryById(inventoryId), HttpStatus.OK) ;
    }
    @PostMapping()
    public ResponseEntity<?> createInventory(@RequestBody Inventory inventory){
        return new ResponseEntity<>(inventoryService.createInventory(inventory),HttpStatus.CREATED) ;
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateInventory(@PathVariable Long id,@RequestBody Inventory inventory){
        return new ResponseEntity(inventoryService.updateInventory(id,inventory),HttpStatus.OK);
    }

    @GetMapping("/code")
    public ResponseEntity<?> getNextItemCode(){
        return new ResponseEntity<>(itemCodeSequenceService.getNextItemCode(),HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteInventory(@RequestParam Long inventoryId){
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
