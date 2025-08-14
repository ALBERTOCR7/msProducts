package com.compustore.products.dto;

import jakarta.validation.constraints.*;
import lombok.Getter; import lombok.Setter;

@Getter @Setter
public class ProductRequest {
  @NotBlank @Size(max=120) private String name;
  @Size(max=500) private String description;
  @NotNull @PositiveOrZero private Double price;
  @NotNull @PositiveOrZero private Integer stock;
}
