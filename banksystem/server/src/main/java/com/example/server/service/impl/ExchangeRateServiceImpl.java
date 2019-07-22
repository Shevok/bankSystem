package com.example.server.service.impl;

import com.example.server.entity.ExchangeRate;
import com.example.server.repository.ExchangeRateRepository;
import com.example.server.service.ExchangeRateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Slf4j
@Service
@Transactional
public class ExchangeRateServiceImpl implements ExchangeRateService {

    @Autowired
    private ExchangeRateRepository exchangeRateRepository;

    @Override
    public ExchangeRate create(ExchangeRate exchangeRate) {
        ExchangeRate createdExchangeRate = exchangeRateRepository.save(exchangeRate);
        log.info("Exchange rate has been created");
        return createdExchangeRate;
    }

    @Override
    public ExchangeRate getOneById(Long id) {
        ExchangeRate exchangeRate = exchangeRateRepository.getOne(id);
        log.info("Exchange rate has been found");
        return exchangeRate;
    }

    @Override
    public List<ExchangeRate> getAll() {
        List<ExchangeRate> allExchangeRates = exchangeRateRepository.findAll();
        log.info("Exchange rates have been found");
        return allExchangeRates ;
    }

    @Override
    public ExchangeRate update(ExchangeRate exchangeRate) {
        ExchangeRate updatedExchangeRate = getOneById(exchangeRate.getId());
        updatedExchangeRate.setDate(exchangeRate.getDate());
        updatedExchangeRate.setCurrencyType(exchangeRate.getCurrencyType());
        updatedExchangeRate.setCurrentRate(exchangeRate.getCurrentRate());
        exchangeRateRepository.save(updatedExchangeRate);
        log.info("Exchange rate has been updated");
        return updatedExchangeRate;
    }

    @Override
    public void deleteOne(ExchangeRate exchangeRate) {
        exchangeRateRepository.delete(exchangeRate);
        log.info("Exchange rate has been deleted");
    }

    @Override
    public List<ExchangeRate> getAllByDate(Date date) {
        List<ExchangeRate> allRates = exchangeRateRepository.findByDate(date);
        log.info("Exchange rate has been deleted");
        return allRates;
    }
}
