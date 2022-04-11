package com.bootcamp.activeAccounts.productType.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class DeleteProductTypeDto {
    @Id
    private String id;
}