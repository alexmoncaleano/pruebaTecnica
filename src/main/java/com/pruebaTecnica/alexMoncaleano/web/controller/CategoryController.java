package com.pruebaTecnica.alexMoncaleano.web.controller;

import com.pruebaTecnica.alexMoncaleano.domain.CategoryDomain;
import com.pruebaTecnica.alexMoncaleano.domain.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

        @Autowired
        private CategoryService categoryService;

        @GetMapping("/")
        public ResponseEntity<List<CategoryDomain>> getAllCategory() {
            return categoryService.getAllCategory().map(category -> new ResponseEntity<>(category, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        }
}
