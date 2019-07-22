package com.example.server.transformer;

import com.example.server.dto.ExchangeRateDto;
import com.example.server.entity.ExchangeRate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@Component
public class ExchangeRateTransformer {

    @Autowired
    private CurrencyTypeTransformer currencyTypeTransformer;

    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");

    public ExchangeRateDto toExchangeRateDto(ExchangeRate exchangeRate){
        ExchangeRateDto exchangeRateDto = new ExchangeRateDto();
        exchangeRateDto.setId(exchangeRate.getId());
        exchangeRateDto.setCurrencyTypeDto(currencyTypeTransformer.toCurrencyTypeDto(exchangeRate.getCurrencyType()));
        exchangeRateDto.setCurrentRate(exchangeRate.getCurrentRate());
        exchangeRateDto.setDate(formatter.format(exchangeRate.getDate()));
        return exchangeRateDto;
    }

    public ExchangeRate toExchangeRate(ExchangeRateDto exchangeRateDto){
        ExchangeRate exchangeRate = new ExchangeRate();
        exchangeRate.setCurrentRate(exchangeRateDto.getCurrentRate());
        exchangeRate.setCurrencyType(currencyTypeTransformer.toCurrencyType(exchangeRateDto.getCurrencyTypeDto()));
        try {
            if(exchangeRateDto.getDate() == null) {
                exchangeRate.setDate(Calendar.getInstance().getTime());
            }else {
                exchangeRate.setDate(formatter.parse(exchangeRateDto.getDate()));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return exchangeRate;
    }
}
