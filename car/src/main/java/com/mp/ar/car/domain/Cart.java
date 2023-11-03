package com.mp.ar.car.domain;

import com.mp.ar.car.DTO.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import lombok.Setter;

import java.util.ArrayList;
import java.util.List;@Getter
@Setter
@AllArgsConstructor
public class Cart {
    private static long nextId = 1;
    private Long idCart;
    private List<ProductDTO> productsListOnTheCart;
    private Double total;

    public Cart() {
        this.idCart = generateAutoIncrementId();
        this.productsListOnTheCart = new ArrayList<>(); // Inicializa la lista como una lista vacía.
        this.total = 0.0; // Inicializa el total en 0.0.
    }

    private synchronized Long generateAutoIncrementId() {
        return nextId++;
    }
}
