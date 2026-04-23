package com.ian_avila.associated_entities_persistence_many.repository;

import com.ian_avila.associated_entities_persistence_many.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
}
