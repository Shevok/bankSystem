package com.example.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class ExchangeRateDto {

    private Long id;

    @NotNull(message = "Exchange rate must have currency type")
    private CurrencyTypeDto currencyTypeDto;

    private String date;

    @NotNull(message = "Exchange rate must have current rate")
    @Min(message = "Current rate must be more then 0", value = 0)
    private Integer currentRate;
}
