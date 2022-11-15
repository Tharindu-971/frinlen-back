package com.techscroll.frinlen.controllers.Whearhouse;

import com.techscroll.frinlen.Entity.Whearhouse.Warehouse;
import com.techscroll.frinlen.Service.Whearhouse.WhearhouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wearhouse")
public class WhearhouseController {
    @Autowired
    private WhearhouseService whearhouseService;


    @GetMapping("/")
    public ResponseEntity<List<Warehouse>> getAllWhearhouses()
    {
        return new ResponseEntity( whearhouseService.findAllWhearhouses(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWhearhouseById(@RequestParam Long whearhouseId){
        return new ResponseEntity<>(whearhouseService.findWhearhouseById(whearhouseId), HttpStatus.OK) ;
    }
    @PostMapping()
    public ResponseEntity<?> createWhearhouse(@RequestBody Warehouse warehouse){
        return new ResponseEntity<>( HttpStatus.OK) ;
    }

    @PutMapping()
    public ResponseEntity<?> updateWhearhouse(@RequestBody Warehouse warehouse){
        return new ResponseEntity<>( HttpStatus.OK);
    }
    @DeleteMapping()
    public ResponseEntity<?> deleteWhearhouse(@RequestParam Long whearhouseId){
        return new ResponseEntity<>( HttpStatus.OK);
    }
}
