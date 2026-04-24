package com.ian_avila.associated_entities_persistence_many.services;

import com.ian_avila.associated_entities_persistence_many.dto.ProductCreateRequest;
import com.ian_avila.associated_entities_persistence_many.dto.ProductResponse;
import com.ian_avila.associated_entities_persistence_many.entities.Category;
import com.ian_avila.associated_entities_persistence_many.entities.Product;
import com.ian_avila.associated_entities_persistence_many.mapper.CategoryMapper;
import com.ian_avila.associated_entities_persistence_many.mapper.ProductMapper;
import com.ian_avila.associated_entities_persistence_many.repository.CategoryRepository;
import com.ian_avila.associated_entities_persistence_many.repository.ProductRepository;
import com.ian_avila.associated_entities_persistence_many.services.exceptions.ResourceNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    final private ProductRepository productRepository;
    final private CategoryRepository categoryRepository;
    final private ProductMapper productMapper;
    final private CategoryMapper categoryMapper;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository, ProductMapper productMapper, CategoryMapper categoryMapper) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.productMapper = productMapper;
        this.categoryMapper = categoryMapper;
    }

    public ProductResponse insert(ProductCreateRequest request) {
        Product product = productMapper.toEntity(request);

        for(Long id : request.categoryIds()) {
            Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Id not found"));
            product.getCategories().add(category);
        }

        product = productRepository.save(product);

        return productMapper.toResponse(product);
    }
}
