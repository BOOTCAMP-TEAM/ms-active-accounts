package com.bootcamp.activeAccounts.productType;

import com.bootcamp.activeAccounts.productType.dto.CreateProductTypeDto;
import com.bootcamp.activeAccounts.productType.dto.DeleteProductTypeDto;
import com.bootcamp.activeAccounts.productType.dto.UpdateProductTypeDto;
import com.bootcamp.activeAccounts.productType.model.ProductType;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/product_type")
@Tag(name = "Active Product Type", description = "Manage Active Product types")
@RequiredArgsConstructor
public class ProductTypeController {

    public final ProductTypeService service;

    @GetMapping
    public Iterable<ProductType> getAll() {
        return service.getAll();
    }

    @PostMapping
    public ProductType create(@RequestBody CreateProductTypeDto o) {
        return service.create(o);
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> update(@RequestBody UpdateProductTypeDto o) {
        return service.update(o);
    }

    @DeleteMapping
    public ResponseEntity<Map<String, Object>> delete(@RequestBody DeleteProductTypeDto o) { return service.delete(o);}

}