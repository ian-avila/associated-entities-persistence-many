package com.ian_avila.associated_entities_persistence_many.repository;

import com.ian_avila.associated_entities_persistence_many.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
