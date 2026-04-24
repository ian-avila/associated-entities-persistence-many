package com.ian_avila.associated_entities_persistence_many.mapper;

import com.ian_avila.associated_entities_persistence_many.dto.CategoryResponse;
import com.ian_avila.associated_entities_persistence_many.entities.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toResponse(Category category);
}
