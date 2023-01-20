package com.pruebaTecnica.alexMoncaleano.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.pruebaTecnica.alexMoncaleano.domain.ProductDomain;
import com.pruebaTecnica.alexMoncaleano.domain.repository.IProductRepository;
import com.pruebaTecnica.alexMoncaleano.persistence.entity.ProductEntity;
import com.pruebaTecnica.alexMoncaleano.persistence.mapper.ProductMapper;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
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
public class ProductRepository implements IProductRepository {

    @Autowired
    private ProductMapper mapper;

    @Override
    public Optional<List<ProductDomain>> getAllProduct() {
        HttpClient httpClient = HttpClient.newHttpClient();
        final HttpRequest requestPosts = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://api.escuelajs.co/api/v1/products"))
                .build();
        try {
            HttpResponse<String> listProduct = httpClient.send(requestPosts, HttpResponse.BodyHandlers.ofString());
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            Optional<List<ProductEntity>> products = Optional.of(Arrays.asList(gson.fromJson(listProduct.body(), ProductEntity[].class)));
            return Optional.of(mapper.toProductsDomain(products.get()));
        } catch (Exception e) {
            return null;
        }
    }


    public Optional<ProductDomain> postProduct(ProductEntity productEntity) {
        try{
        ObjectMapper objectMapper = new ObjectMapper();
        String requestBody = objectMapper
                .writeValueAsString(productEntity);
            CloseableHttpClient client = HttpClients.createDefault();
            HttpPost request = new HttpPost("https://api.escuelajs.co/api/v1/products");
            request.addHeader("Content-Type", "application/json");
            request.setEntity(new StringEntity(requestBody));
            CloseableHttpResponse response = client.execute(request);
            GsonBuilder builder = new GsonBuilder();
            builder.setPrettyPrinting();
            Gson gson = builder.create();
            ProductEntity product = gson.fromJson(EntityUtils.toString(response.getEntity()), ProductEntity.class);
            return Optional.of(mapper.toProductDomain(product));
        } catch (Exception e) {
            return null;
        }
    }
}
