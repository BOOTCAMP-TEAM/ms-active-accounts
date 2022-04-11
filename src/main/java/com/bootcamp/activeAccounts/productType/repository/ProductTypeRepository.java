package com.bootcamp.activeAccounts.productType.repository;

        import com.bootcamp.activeAccounts.productType.model.ProductType;
        import org.springframework.data.repository.CrudRepository;

public interface ProductTypeRepository extends CrudRepository<ProductType, String> {



}