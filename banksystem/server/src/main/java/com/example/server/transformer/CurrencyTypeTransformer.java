package com.example.server.transformer;

import com.example.server.dto.CurrencyTypeDto;
import com.example.server.entity.CurrencyType;
import org.springframework.stereotype.Component;

@Component
public class CurrencyTypeTransformer {

    public CurrencyTypeDto toCurrencyTypeDto(CurrencyType currencyType){
        CurrencyTypeDto currencyTypeDto = new CurrencyTypeDto();
        currencyTypeDto.setCode(currencyType.getCode());
        currencyTypeDto.setName(currencyType.getName());
        return currencyTypeDto;
    }

    public CurrencyType toCurrencyType (CurrencyTypeDto currencyTypeDto){
        CurrencyType currencyType = new CurrencyType();
        currencyType.setCode(currencyTypeDto.getCode());
        currencyType.setName(currencyTypeDto.getName());
        return currencyType;
    }
}
