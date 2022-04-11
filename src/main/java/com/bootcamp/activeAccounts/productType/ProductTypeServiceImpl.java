package com.bootcamp.activeAccounts.productType;

import com.bootcamp.activeAccounts.productType.dto.CreateProductTypeDto;
import com.bootcamp.activeAccounts.productType.dto.DeleteProductTypeDto;
import com.bootcamp.activeAccounts.productType.dto.UpdateProductTypeDto;
import com.bootcamp.activeAccounts.productType.model.ProductType;
import com.bootcamp.activeAccounts.productType.repository.ProductTypeRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductTypeServiceImpl implements ProductTypeService {

    public final ProductTypeRepository repository;

    @Override
    public Iterable<ProductType> getAll() {
        return repository.findAll();
    }

    @Override
    public ProductType create(CreateProductTypeDto o) {

        ProductType p = new ProductType(
                (String) null,
                o.getDescription(),
                o.getAbbreviation(),
                (short) 1,
                new Date(),
                o.getFk_insertionUser(),
                o.getInsertionTerminal()
        );

        return repository.save(p);
    }

    @Override
    public ResponseEntity<Map<String, Object>> update(UpdateProductTypeDto o) {

        Map<String, Object> response = new HashMap<>();

        try {

            Optional<ProductType> p = repository.findById(o.getId());

            if (p.isEmpty()) {
                response.put("Message","An error occurred while trying to update the item with id " + o.getId() + ".");
                response.put("Error", "An item with the id " + o.getId() + " was not found.");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }

            ProductType updated_p = new ProductType(
                    o.getId(),
                    o.getDescription(),
                    o.getAbbreviation(),
                    p.get().getRegistrationStatus(),
                    p.get().getInsertionDate(),
                    p.get().getFk_insertionUser(),
                    p.get().getInsertionTerminal()
            );

            repository.save(updated_p);

            response.put("Message","The item with id " + o.getId() + "was successfully updated.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);

        } catch (Exception e) {
            response.put("Message","An error occurred while trying to update the item with id " + o.getId() + ".");
            response.put("Error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public ResponseEntity<Map<String, Object>> delete(DeleteProductTypeDto o) {

        Map<String, Object> response = new HashMap<>();

        try {
            if (repository.findById(o.getId()).isEmpty()) {
                response.put("Message","An error occurred while trying to delete the item with id " + o.getId() + ".");
                response.put("Error", "An item with the id " + o.getId() + " was not found.");
                return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
            }

            ProductType p = new ProductType();
            p.setId(o.getId());
            repository.delete(p);

            response.put("Message","The item with id " + o.getId() + "was successfully deleted.");
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
        } catch (Exception e) {
            response.put("Message","An error occurred while trying to delete the item with id " + o.getId() + ".");
            response.put("Error", e.getMessage());
            return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}