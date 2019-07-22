package com.example.server.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@NoArgsConstructor
@Data
@Entity
@Table(name = "currency_types")
public class CurrencyType implements Serializable {

    @Id
    @Column(name = "code")
    private Long code;

    @Column(name = "name" )
    private String name;
}
