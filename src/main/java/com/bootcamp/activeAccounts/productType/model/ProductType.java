package com.bootcamp.activeAccounts.productType.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document
public class ProductType {

    @Id
    private String id;
    private String description;
    private String abbreviation;
    //private String isoCurrencyCode;
    //private BigDecimal interesRate;
    private short registrationStatus;
    private Date insertionDate = new Date();
    private String fk_insertionUser;
    private String insertionTerminal;

}