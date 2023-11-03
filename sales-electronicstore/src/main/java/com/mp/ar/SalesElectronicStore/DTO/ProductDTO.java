package com.mp.ar.SalesElectronicStore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Long idProduct;
    private String nameProduct;
    private String brand;
    private Double price;
    private Long idCart;
}
