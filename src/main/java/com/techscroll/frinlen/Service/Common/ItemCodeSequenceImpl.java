package com.techscroll.frinlen.Service.Common;

import com.techscroll.frinlen.Entity.Common.ItemCodeSequence;
import com.techscroll.frinlen.repository.Common.ItemCodeSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemCodeSequenceImpl implements ItemCodeSequenceService{

    @Autowired
    private ItemCodeSequenceRepository itemCodeSequenceRepository;

    @Override
    public ItemCodeSequence getNextItemCode(){
        ItemCodeSequence latestItemCode = itemCodeSequenceRepository.findTopByOrderByIdDesc();
        ItemCodeSequence createdCode = new ItemCodeSequence();
        if(latestItemCode!=null){
            long code =latestItemCode.getCode()+1L;
            ItemCodeSequence newCode = new ItemCodeSequence().builder()
                    .code(code)
                    .build();
            createdCode = itemCodeSequenceRepository.save(newCode);
        }else {
            ItemCodeSequence newCode = new ItemCodeSequence().builder()
                    .code(1000L)
                    .build();
            createdCode = itemCodeSequenceRepository.save(newCode);
        }
        return createdCode;
    }
}
