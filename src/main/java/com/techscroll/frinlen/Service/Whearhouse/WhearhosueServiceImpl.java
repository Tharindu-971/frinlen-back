package com.techscroll.frinlen.Service.Whearhouse;


import com.techscroll.frinlen.Entity.Whearhouse.Warehouse;
import com.techscroll.frinlen.repository.Whearhouse.WhearhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhearhosueServiceImpl implements WhearhouseService {
    @Autowired
    private WhearhouseRepository whearhouseRepository;
    @Override
    public List<Warehouse> findAllWhearhouses(){
        return whearhouseRepository.findAll();
    }
    @Override
    public Warehouse findWhearhouseById(Long whearhouseId){
        return whearhouseRepository.findById(whearhouseId).get();
    }
    @Override
    public void createWhearhouse(Warehouse warehouse){
        Warehouse whearhouses = whearhouseRepository.findByName(warehouse.getName());
        if(whearhouses != null){
            return ;
        }
        Warehouse warehouseCreated = whearhouseRepository.save(warehouse);
    }
    @Override
    public void deleteWhearhouse(Long whearhouseId){
        Warehouse warehouse = whearhouseRepository.findById(whearhouseId).get();
        if(warehouse != null){
            warehouse.isActive(false);
            whearhouseRepository.save(warehouse);
        }else {
            return ;
        }

    }
    @Override
    public void updateWhearhouse(Warehouse warehouse){
        Warehouse whearhouses = whearhouseRepository.findById(warehouse.getId()).get();
        if(whearhouses != null){
            Warehouse warehouseCreated = whearhouseRepository.save(warehouse);
        }
        return ;
    }
}
