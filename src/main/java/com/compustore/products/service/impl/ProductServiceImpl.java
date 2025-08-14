package com.compustore.products.service.impl;

import com.compustore.products.dto.ProductRequest;
import com.compustore.products.model.Product;
import com.compustore.products.repository.ProductRepository;
import com.compustore.products.service.ProductService;
import org.springframework.stereotype.Service;
  import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
  private final ProductRepository repo;
  public ProductServiceImpl(ProductRepository repo){ this.repo = repo; }

  @Override public List<Product> findAll(){ return repo.findAll(); }
  @Override public Product findById(Long id){ return repo.findById(id).orElseThrow(); }

  @Override @Transactional
  public Product create(ProductRequest req){
    Product p = Product.builder()
      .name(req.getName()).description(req.getDescription())
      .price(req.getPrice()).stock(req.getStock()).build();
    return repo.save(p);
  }

  @Override @Transactional
  public Product update(Long id, ProductRequest req){
    Product p = findById(id);
    p.setName(req.getName()); p.setDescription(req.getDescription());
    p.setPrice(req.getPrice()); p.setStock(req.getStock());
    return repo.save(p);
  }

  @Override @Transactional
  public void delete(Long id){ repo.deleteById(id); }
}
