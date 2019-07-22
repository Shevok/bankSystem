package com.example.server.service;

import com.example.server.entity.ExchangeRate;

import java.util.Date;
import java.util.List;

public interface ExchangeRateService {

    ExchangeRate create(ExchangeRate exchangeRate);

    ExchangeRate getOneById(Long id);

    List<ExchangeRate> getAll();

    ExchangeRate update(ExchangeRate exchangeRate);

    void deleteOne(ExchangeRate exchangeRate);

    List<ExchangeRate> getAllByDate(Date date);
}
