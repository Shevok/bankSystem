package com.example.server.service;

import com.example.server.entity.CurrencyType;

import java.util.List;


public interface CurrencyTypeService {

    CurrencyType create(CurrencyType currencyType);

    CurrencyType getOneByCode(Long code);

    List<CurrencyType> getAll();

    CurrencyType update(CurrencyType currencyType);

    void deleteOne(CurrencyType currencyType);
}
