package com.compustore.products.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor @Builder
@Entity @Table(name="products")
public class Product {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable=false, length=120) private String name;
  @Column(length=500) private String description;
  @Column(nullable=false) private Double price;
  @Column(nullable=false) private Integer stock;

  @Column(name="created_at", nullable=false) private LocalDateTime createdAt;
  @Column(name="updated_at", nullable=false) private LocalDateTime updatedAt;

  @PrePersist void prePersist(){ createdAt = updatedAt = LocalDateTime.now(); }
  @PreUpdate  void preUpdate(){ updatedAt = LocalDateTime.now(); }
}
