package com.pruebaTecnica.alexMoncaleano.domain.repository;

import com.pruebaTecnica.alexMoncaleano.domain.CategoryDomain;

import java.util.List;
import java.util.Optional;

public interface ICategoryRepository {


    Optional<List<CategoryDomain>> getAllCategory();
}
