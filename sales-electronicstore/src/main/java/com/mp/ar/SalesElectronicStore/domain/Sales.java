package com.mp.ar.SalesElectronicStore.domain;

import com.mp.ar.SalesElectronicStore.DTO.ProductDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Entity
@Table(name= "sales")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idSale;

    @Temporal(TemporalType.DATE)
    private Date saleDate;

    private Double total;


}
