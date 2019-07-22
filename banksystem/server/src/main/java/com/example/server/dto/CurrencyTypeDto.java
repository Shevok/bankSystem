package com.example.server.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CurrencyTypeDto {

    @NotNull(message = "Currency must have value")
    @Min(value = 0,message = "Currency code must be more then 0")
    private Long code;

    @NotBlank(message = "Currency must have name")
    private String name;
}
