package com.compustore.products.service;

import com.compustore.products.dto.ProductRequest;
import com.compustore.products.model.Product;
import java.util.List;

public interface ProductService {
  List<Product> findAll();
  Product findById(Long id);
  Product create(ProductRequest req);
  Product update(Long id, ProductRequest req);
  void delete(Long id);
}
