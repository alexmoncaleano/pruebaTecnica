package com.pruebaTecnica.alexMoncaleano.domain.service;

import com.pruebaTecnica.alexMoncaleano.domain.CategoryDomain;
import com.pruebaTecnica.alexMoncaleano.domain.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    public Optional<List<CategoryDomain>> getAllCategory(){
        return categoryRepository.getAllCategory();
    }

}
