package com.mp.ar.SalesElectronicStore.DTO;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDTO {

    private Long idCart;
    private Double totalSale;
    private List<ProductDTO> productsListOnTheCart;
}
