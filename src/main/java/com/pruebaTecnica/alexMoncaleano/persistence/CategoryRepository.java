package com.pruebaTecnica.alexMoncaleano.persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pruebaTecnica.alexMoncaleano.domain.CategoryDomain;
import com.pruebaTecnica.alexMoncaleano.domain.repository.ICategoryRepository;
import com.pruebaTecnica.alexMoncaleano.persistence.entity.CategoryEntity;
import com.pruebaTecnica.alexMoncaleano.persistence.mapper.CategoryMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository implements ICategoryRepository {
    @Autowired
    private CategoryMapper mapper;

    @Override
    public Optional<List<CategoryDomain>> getAllCategory() {
        HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest requestPosts = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.escuelajs.co/api/v1/categories"))
                .build();
        try {
            HttpResponse<String> listCategories = httpClient.send(requestPosts, HttpResponse.BodyHandlers.ofString());
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            List<CategoryEntity> categories = Arrays.asList(gson.fromJson(listCategories.body(),CategoryEntity[].class));
            return Optional.of(mapper.toCategorysDomain(categories));
        } catch (Exception e) {
            return null;
        }

    }

}


