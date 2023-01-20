package com.pruebaTecnica.alexMoncaleano.domain.service;

import com.pruebaTecnica.alexMoncaleano.domain.ProductDomain;
import com.pruebaTecnica.alexMoncaleano.domain.repository.IProductRepository;
import com.pruebaTecnica.alexMoncaleano.persistence.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private IProductRepository productRepository;

    public Optional<List<ProductDomain>> getAllProduct(){
        return productRepository.getAllProduct();
    }

    public Optional<ProductDomain> postProduct(@RequestBody ProductEntity product){
        return productRepository.postProduct(product);
    }


}
