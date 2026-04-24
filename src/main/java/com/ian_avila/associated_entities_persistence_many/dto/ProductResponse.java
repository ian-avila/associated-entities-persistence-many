package com.ian_avila.associated_entities_persistence_many.dto;

import java.util.List;

public record ProductResponse(Long id, String name, Double price, List<CategoryResponse> categories) {
}
