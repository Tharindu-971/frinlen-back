package com.techscroll.frinlen.Service.Common;

import com.techscroll.frinlen.Entity.Common.ItemCodeSequence;
import org.springframework.stereotype.Service;

@Service
public interface ItemCodeSequenceService {
    ItemCodeSequence getNextItemCode();
}
