package com.mp.ar.SalesElectronicStore.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {

    private Long idSale;
    private Date saleDate;
    private CartDTO cartReadyToSale;
}
