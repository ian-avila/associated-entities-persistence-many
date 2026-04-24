package com.ian_avila.associated_entities_persistence_many.controllers;


import com.ian_avila.associated_entities_persistence_many.dto.ProductCreateRequest;
import com.ian_avila.associated_entities_persistence_many.dto.ProductResponse;
import com.ian_avila.associated_entities_persistence_many.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Controller
@RequestMapping(value = "/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping
    public ResponseEntity<ProductResponse> insert(@RequestBody ProductCreateRequest request) {
        ProductResponse response = productService.insert(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(response.id()).toUri();
        return ResponseEntity.created(uri).body(response);
    }
}
