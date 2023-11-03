package com.mp.ar.products.domain;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Table(name = "products")
@Setter @Builder
@AllArgsConstructor
@NoArgsConstructor
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduct;
    private String nameProduct;
    private String brand;
    private Double price;

}
