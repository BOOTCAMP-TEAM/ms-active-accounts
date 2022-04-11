package com.bootcamp.activeAccounts.productType;

import com.bootcamp.activeAccounts.productType.dto.CreateProductTypeDto;
import com.bootcamp.activeAccounts.productType.dto.DeleteProductTypeDto;
import com.bootcamp.activeAccounts.productType.dto.UpdateProductTypeDto;
import com.bootcamp.activeAccounts.productType.model.ProductType;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ProductTypeService {

    public Iterable<ProductType> getAll();
    public ProductType create(CreateProductTypeDto o);
    public ResponseEntity<Map<String, Object>> update(UpdateProductTypeDto o);
    public ResponseEntity<Map<String, Object>> delete(DeleteProductTypeDto o);

}