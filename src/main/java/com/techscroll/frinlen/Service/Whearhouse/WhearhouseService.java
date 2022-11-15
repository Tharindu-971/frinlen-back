package com.techscroll.frinlen.Service.Whearhouse;

import com.techscroll.frinlen.Entity.Whearhouse.Warehouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WhearhouseService {
    List<Warehouse> findAllWhearhouses();

    Warehouse findWhearhouseById(Long whearhouseId);

    void createWhearhouse(Warehouse warehouse);

    void deleteWhearhouse(Long whearhouseId);

    void updateWhearhouse(Warehouse warehouse);


}
