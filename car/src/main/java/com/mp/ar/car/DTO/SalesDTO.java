package com.mp.ar.car.DTO;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesDTO {

    private Long idSale;
    @Temporal(TemporalType.DATE)
    private Date saleDate;
    private Double total;
    private List<ProductDTO> productsSold;
}
