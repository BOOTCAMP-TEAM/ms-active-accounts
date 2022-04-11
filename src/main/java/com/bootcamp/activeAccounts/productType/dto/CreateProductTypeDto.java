package com.bootcamp.activeAccounts.productType.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class CreateProductTypeDto {

    private String description;
    private String abbreviation;
    /*private short registrationStatus;
    private Date insertionDate = new Date();*/
    private String fk_insertionUser;
    private String insertionTerminal;

}