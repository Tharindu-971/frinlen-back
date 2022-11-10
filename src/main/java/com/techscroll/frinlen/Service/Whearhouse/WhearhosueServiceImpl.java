package com.techscroll.frinlen.Service.Whearhouse;


import com.techscroll.frinlen.Entity.Whearhouse.Whearhouse;
import com.techscroll.frinlen.repository.Whearhouse.WhearhouseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WhearhosueServiceImpl implements WhearhouseService {
    @Autowired
    private WhearhouseRepository whearhouseRepository;
    @Override
    public List<Whearhouse> findAllWhearhouse(){
        return whearhouseRepository.findAll();
    }
    @Override
    public Whearhouse findWhearhouseById(Long whearhouseId){
        return whearhouseRepository.findById(whearhouseId).get();
    }
    @Override
    public void createWhearhouse(Whearhouse whearhouse){
        Whearhouse whearhouses = whearhouseRepository.findByName(whearhouse.getName());
        if(whearhouses != null){
            return ;
        }
        Whearhouse whearhouseCreated = whearhouseRepository.save(whearhouse);
    }
    @Override
    public void deleteWhearhouse(Long whearhouseId){
        Whearhouse whearhouse = whearhouseRepository.findById(whearhouseId).get();
        if(whearhouse != null){
            whearhouse.isActive(false);
            whearhouseRepository.save(whearhouse);
        }else {
            return ;
        }

    }
    @Override
    public void updateWhearhouse(Whearhouse whearhouse){
        Whearhouse whearhouses = whearhouseRepository.findById(whearhouse.getId().get());
        if(whearhouses != null){
            Whearhouse whearhouseCreated = whearhouseRepository.save(whearhouse);
        }
        return ;
    }
}
