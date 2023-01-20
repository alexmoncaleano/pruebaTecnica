package com.pruebaTecnica.alexMoncaleano.persistence.mapper;

import com.pruebaTecnica.alexMoncaleano.domain.CategoryDomain;
import com.pruebaTecnica.alexMoncaleano.persistence.entity.CategoryEntity;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {


    @Mappings({
            @Mapping(source = "id", target = "cid"),
            @Mapping(source = "name", target = "title"),
    })
    CategoryDomain toCategoryDomain (CategoryEntity categoryEntity);
    List<CategoryDomain> toCategorysDomain (List<CategoryEntity> categoryEntities);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "updatedAt", ignore = true),
            @Mapping(target = "creationAt", ignore = true),
            @Mapping(target = "image", ignore = true),
    })
    CategoryEntity toCategoryEntity(CategoryDomain categoryDomain);
}
