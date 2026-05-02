package com.example.cicd.controller;

import com.example.cicd.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final List<Product> products = new ArrayList<>(List.of(
            new Product(1L, "Laptop", 999.99),
            new Product(2L, "Mouse", 29.99),
            new Product(3L, "Keyboard", 79.99),
            new Product(4L, "Monitor", 349.99),
            new Product(5L, "Headset", 89.99),
            new Product(6L, "Webcam", 59.99),
            new Product(7L, "USB Hub", 39.99),
            new Product(8L, "SSD 1TB", 119.99),
            new Product(9L, "Mousepad XL", 24.99),
            new Product(10L, "Microphone", 149.99),
            new Product(11L, "Chair Gaming", 499.99),
            new Product(12L, "Desk Lamp", 34.99)
    ));
    private final AtomicLong idCounter = new AtomicLong(13);

    @GetMapping
    public List<Product> getAll() {
        return products;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        product.setId(idCounter.getAndIncrement());
        products.add(product);
        return product;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean removed = products.removeIf(p -> p.getId().equals(id));
        return removed ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
