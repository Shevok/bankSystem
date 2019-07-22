package com.example.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@Data
@Entity
@Table(name = "exchange_rates")
public class ExchangeRate implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "currency_code")
    private CurrencyType currencyType;

    @Column(name = "date")
    private Date date;

    @Column(name = "current_rate" )
    private Integer currentRate;
}
