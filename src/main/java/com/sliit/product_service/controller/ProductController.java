package com.sliit.product_service.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import com.sliit.product_service.model.Product;
import com.sliit.product_service.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository repository;

    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    // POST - Create Product
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repository.save(product);
    }

    // GET - Get All Products
    @GetMapping
    public List<Product> getAllProducts() {
        return repository.findAll();
    }

    // GET by ID
    @GetMapping("/{id}")
    public Optional<Product> getProductById(@PathVariable Long id) {
        return repository.findById(id);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }
}
