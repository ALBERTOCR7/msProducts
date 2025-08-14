package com.compustore.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.compustore.products.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
