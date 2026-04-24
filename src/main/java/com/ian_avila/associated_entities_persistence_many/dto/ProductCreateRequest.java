package com.ian_avila.associated_entities_persistence_many.dto;

import java.util.List;
import java.util.Set;

public record ProductCreateRequest(String name, Double price, Set<Long> categoryIds) {
}
