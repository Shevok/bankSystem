package com.example.server.controller;

import com.example.server.dto.CurrencyTypeDto;
import com.example.server.service.CurrencyTypeService;
import com.example.server.transformer.CurrencyTypeTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/currencyTypes")
public class CurrencyTypeController {

    @Autowired
    private CurrencyTypeService currencyTypeService;

    @Autowired
    private CurrencyTypeTransformer currencyTypeTransformer;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<CurrencyTypeDto> createCity(@RequestBody @Valid CurrencyTypeDto currencyTypeDto) {
        CurrencyTypeDto createdCurrencyTypeDto = currencyTypeTransformer.toCurrencyTypeDto(
                currencyTypeService.create(currencyTypeTransformer.toCurrencyType(currencyTypeDto)));
        return new ResponseEntity<>(createdCurrencyTypeDto, HttpStatus.OK);
    }

    @RequestMapping(value = "/{code}", method = RequestMethod.GET)
    public ResponseEntity<CurrencyTypeDto> getOneByCode(@PathVariable("code") Long code) {
        CurrencyTypeDto currencyTypeDto = currencyTypeTransformer.toCurrencyTypeDto(
                currencyTypeService.getOneByCode(code));
        return new ResponseEntity<>(currencyTypeDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<List<CurrencyTypeDto>> getAll() {
        List<CurrencyTypeDto> allCurrencyTypes = currencyTypeService.getAll()
                .stream()
                .map(currencyTypeTransformer::toCurrencyTypeDto)
                .collect(Collectors.toList());
        return new ResponseEntity<>(allCurrencyTypes, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public ResponseEntity<CurrencyTypeDto> updateCurrencyType(@RequestBody @Valid CurrencyTypeDto currencyTypeDto) {
        CurrencyTypeDto updatedCurrencyTypeDto = currencyTypeTransformer.toCurrencyTypeDto(
                currencyTypeService.update(currencyTypeTransformer.toCurrencyType(currencyTypeDto)));
        return new ResponseEntity<>(updatedCurrencyTypeDto, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.DELETE)
    public ResponseEntity<CurrencyTypeDto> deleteCurrencyType(@RequestBody @Valid CurrencyTypeDto currencyTypeDto) {
                currencyTypeService.deleteOne(currencyTypeTransformer.toCurrencyType(currencyTypeDto));
        return new ResponseEntity<>(currencyTypeDto, HttpStatus.OK);
    }



}
