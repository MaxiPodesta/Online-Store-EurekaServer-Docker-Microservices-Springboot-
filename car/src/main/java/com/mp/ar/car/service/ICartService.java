package com.mp.ar.car.service;


import com.mp.ar.car.domain.Cart;

public interface ICartService {

    void addProductToCart(Long productId);
   void removeProductFromCart( Long productId);
    Cart findCartById();

    public String checkOut();
}
