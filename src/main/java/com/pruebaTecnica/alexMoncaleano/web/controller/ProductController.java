package com.pruebaTecnica.alexMoncaleano.web.controller;

import com.pruebaTecnica.alexMoncaleano.domain.ProductDomain;
import com.pruebaTecnica.alexMoncaleano.domain.service.ProductService;
import com.pruebaTecnica.alexMoncaleano.persistence.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/")
    public ResponseEntity<List<ProductDomain>> getAllProduct() {
        return productService.getAllProduct().map(product -> new ResponseEntity<>(product, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<ProductDomain> postProduct(@RequestBody ProductEntity product) {
        return productService.postProduct(product).map(productDomain -> new ResponseEntity<>(productDomain, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}