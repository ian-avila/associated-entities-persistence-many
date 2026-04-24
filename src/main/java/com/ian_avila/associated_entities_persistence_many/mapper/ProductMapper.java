package com.ian_avila.associated_entities_persistence_many.mapper;

import com.ian_avila.associated_entities_persistence_many.dto.ProductCreateRequest;
import com.ian_avila.associated_entities_persistence_many.dto.ProductResponse;
import com.ian_avila.associated_entities_persistence_many.entities.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = CategoryMapper.class)
public interface ProductMapper {

    ProductResponse toResponse(Product product);

    @Mapping(target = "categories", ignore = true)
    Product toEntity(ProductCreateRequest request);

}
