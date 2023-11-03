package com.mp.ar.SalesElectronicStore.service;

import com.mp.ar.SalesElectronicStore.DTO.CartDTO;
import com.mp.ar.SalesElectronicStore.DTO.SaleDTO;
import com.mp.ar.SalesElectronicStore.domain.Sales;

import java.util.List;

public interface ISaleService {

    public Sales getSaleInfo(Long saleId);
    public Sales buy (Long cartId);
    public List<Sales> listSales();
    public CartDTO getCart(Long idCart);



}
