package com.compustore.products.controller;

import com.compustore.products.dto.ProductRequest;
import com.compustore.products.model.Product;
import com.compustore.products.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/products")
public class ProductController {
  private final ProductService service;
  public ProductController(ProductService service){ this.service = service; }

  @GetMapping public ResponseEntity<List<Product>> all(){ return ResponseEntity.ok(service.findAll()); }
  @GetMapping("/{id}") public ResponseEntity<Product> one(@PathVariable Long id){ return ResponseEntity.ok(service.findById(id)); }
  @PostMapping public ResponseEntity<Product> create(@Valid @RequestBody ProductRequest req){ return ResponseEntity.ok(service.create(req)); }
  @PutMapping("/{id}") public ResponseEntity<Product> update(@PathVariable Long id, @Valid @RequestBody ProductRequest req){ return ResponseEntity.ok(service.update(id, req)); }
  @DeleteMapping("/{id}") public ResponseEntity<Void> delete(@PathVariable Long id){ service.delete(id); return ResponseEntity.noContent().build(); }
}
