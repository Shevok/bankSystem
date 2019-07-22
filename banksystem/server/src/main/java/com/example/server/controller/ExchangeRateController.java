package com.example.server.controller;

import com.example.server.dto.ExchangeRateDto;
import com.example.server.service.ExchangeRateService;
import com.example.server.transformer.ExchangeRateTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/exchangeRates")
public class ExchangeRateController {

    @Autowired
    private ExchangeRateService exchangeRateService;

    @Autowired
    private ExchangeRateTransformer exchangeRateTransformer;

    SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");


    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ExchangeRateDto> createCity(@RequestBody @Valid ExchangeRateDto exchangeRateDto) {
        ExchangeRateDto createdExchangeRateDto = exchangeRateTransformer.toExchangeRateDto(
                exchangeRateService.create(exchangeRateTransformer.toExchangeRate(exchangeRateDto)));
        return new ResponseEntity<>(createdExchangeRateDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ExchangeRateDto> getOneByCode(@PathVariable("id") Long id) {
        ExchangeRateDto exchangeRateDto = exchangeRateTransformer.toExchangeRateDto(
                exchangeRateService.getOneById(id));
        return new ResponseEntity<>(exchangeRateDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<ExchangeRateDto>> getAll() {
        List<ExchangeRateDto> allExchangeRateDto = exchangeRateService.getAll()
                .stream()
                .map(exchangeRateTransformer::toExchangeRateDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(allExchangeRateDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<ExchangeRateDto> updateCurrencyType(@RequestBody @Valid ExchangeRateDto exchangeRateDto) {
        ExchangeRateDto updatedExchangeRateDto = exchangeRateTransformer.toExchangeRateDto(
                exchangeRateService.update(exchangeRateTransformer.toExchangeRate(exchangeRateDto)));
        return new ResponseEntity<>(updatedExchangeRateDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<ExchangeRateDto> deleteCurrencyType(@RequestBody @Valid ExchangeRateDto exchangeRateDto) {
        exchangeRateService.deleteOne(exchangeRateTransformer.toExchangeRate(exchangeRateDto));
        return new ResponseEntity<>(exchangeRateDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/date/{date}", method = RequestMethod.GET)
    public ResponseEntity<List<ExchangeRateDto>> getAllByDate(@PathVariable("date") String date) {
        List<ExchangeRateDto> allExchangeRateDto = new ArrayList<>();
        try {
            allExchangeRateDto = exchangeRateService.getAllByDate(formatter.parse(date))
                    .stream()
                    .map(exchangeRateTransformer::toExchangeRateDto)
                    .collect(Collectors.toList());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(allExchangeRateDto, HttpStatus.OK);
    }

}
