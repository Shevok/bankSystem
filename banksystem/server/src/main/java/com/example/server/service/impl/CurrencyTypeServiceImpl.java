package com.example.server.service.impl;

import com.example.server.entity.CurrencyType;
import com.example.server.repository.CurrencyTypeRepository;
import com.example.server.service.CurrencyTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Slf4j
@Service
@Transactional
public class CurrencyTypeServiceImpl implements CurrencyTypeService {

    @Autowired
    private CurrencyTypeRepository currencyTypeRepository;

    @Override
    public CurrencyType create(CurrencyType currencyType) {
        CurrencyType createdCurrencyType = currencyTypeRepository.save(currencyType);
        log.info("Currency type has been created");
        return createdCurrencyType;
    }

    @Override
    public CurrencyType getOneByCode(Long code) {
        CurrencyType createdCurrencyType = currencyTypeRepository.findById(code)
                .orElseThrow(()-> new EntityNotFoundException("Entity with code " + code + " not found"));
        ;
        log.info("Currency type has been found");
        return createdCurrencyType;
    }

    @Override
    public List<CurrencyType> getAll() {
        List<CurrencyType> allCurrencyTypes = currencyTypeRepository.findAll();
        log.info("All currency types have been found");
        return allCurrencyTypes;
    }

    @Override
    public CurrencyType update(CurrencyType currencyType) {
        CurrencyType updatedCurrencyType = getOneByCode(currencyType.getCode());
        updatedCurrencyType.setCode(currencyType.getCode());
        updatedCurrencyType.setName(currencyType.getName());
        currencyTypeRepository.save(updatedCurrencyType);
        log.info("Currency type has been updated");
        return updatedCurrencyType;
    }

    @Override
    public void deleteOne(CurrencyType currencyType) {
        currencyTypeRepository.delete(currencyType);
        log.info("Currency type has been deleted");
    }
}
