package com.pruebaTecnica.alexMoncaleano.persistence.mapper;

import com.pruebaTecnica.alexMoncaleano.domain.ProductDomain;
import com.pruebaTecnica.alexMoncaleano.persistence.entity.ProductEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mappings({
            @Mapping(source = "id", target = "pid"),
            @Mapping(source = "title", target = "name"),
            @Mapping(source = "price", target = "priceFinal"),
            @Mapping(source = "description", target = "description"),
    })
    ProductDomain toProductDomain(ProductEntity productEntity);
    List<ProductDomain> toProductsDomain(List<ProductEntity> productEntities );

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "creationAt", ignore = true),
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "images", ignore = true),
            @Mapping(target = "categoryId", ignore = true),
    })
    ProductEntity toProductEntity (ProductDomain productDomain);
}
