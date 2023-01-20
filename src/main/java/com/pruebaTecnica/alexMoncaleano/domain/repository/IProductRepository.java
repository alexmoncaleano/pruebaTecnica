package com.pruebaTecnica.alexMoncaleano.domain.repository;

import com.pruebaTecnica.alexMoncaleano.domain.ProductDomain;
import com.pruebaTecnica.alexMoncaleano.persistence.entity.ProductEntity;
import java.util.List;
import java.util.Optional;


public interface IProductRepository {

    public Optional<List<ProductDomain>> getAllProduct();
    public Optional<ProductDomain> postProduct(ProductEntity productEntity);
}
