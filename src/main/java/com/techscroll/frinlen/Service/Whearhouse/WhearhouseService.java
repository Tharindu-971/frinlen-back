package com.techscroll.frinlen.Service.Whearhouse;

import com.techscroll.frinlen.Entity.Brand.Brand;
import com.techscroll.frinlen.Entity.Whearhouse.Whearhouse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface WhearhouseService {
    List<Whearhouse> findAllWhearhouses();

    Whearhouse findWhearhouseById(Long whearhouseId);

    void createWhearhouse(Whearhouse whearhouse);

    void deleteWhearhouse(Long whearhouseId);

    void updateWhearhouse(Whearhouse whearhouse);


}
