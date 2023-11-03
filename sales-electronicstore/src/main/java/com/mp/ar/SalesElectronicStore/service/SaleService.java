package com.mp.ar.SalesElectronicStore.service;

import com.mp.ar.SalesElectronicStore.DTO.CartDTO;
import com.mp.ar.SalesElectronicStore.DTO.SaleDTO;
import com.mp.ar.SalesElectronicStore.domain.Sales;
import com.mp.ar.SalesElectronicStore.repository.IApiCart;
import com.mp.ar.SalesElectronicStore.repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SaleService implements ISaleService {

    private final IApiCart cartApi;
    private final SalesRepository saleRepo;

    @Autowired
    public SaleService(IApiCart cartApi, SalesRepository saleRepo) {
        this.cartApi = cartApi;
        this.saleRepo = saleRepo;
    }

    // Retrieve the details of a shopping cart by its ID.
    @Override
    public CartDTO getCart(Long idCart) {
        if (idCart == null) {
            throw new IllegalArgumentException("idCart can't be null");
        }
        return cartApi.getCartDetails(idCart);
    }


    // Process a purchase by creating a sales record.
    @Override
    public Sales buy(Long cartId) {
        CartDTO cart = getCart(cartId);
        if (cart == null) {
            throw new IllegalArgumentException("Couldn't get the cart");
        }

        Sales sale = new Sales();
        sale.setSaleDate(new Date());
        sale.setTotal(cart.getTotalSale());

        return saleRepo.save(sale);
    }

    @Override
    public List<Sales> listSales() {
        return saleRepo.findAll();
    }

    @Override
    public Sales getSaleInfo(Long saleId) {
        return saleRepo.findById(saleId).orElse(null);
    }
}
