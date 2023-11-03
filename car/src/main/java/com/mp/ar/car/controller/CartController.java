package com.mp.ar.car.controller;

import com.mp.ar.car.DTO.ProductDTO;
import com.mp.ar.car.domain.Cart;
import com.mp.ar.car.service.CartService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private final CartService cartService;
    private final static Logger logger = LoggerFactory.getLogger(CartController.class);

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/shop")
    public Cart getCart(){
        return cartService.findCartById();
    }

    @PostMapping("/shop/add/{productId}")
    public String addProductToCart(@PathVariable Long productId) {
        cartService.addProductToCart(productId);
    return "Product added to the cart";
    }

    @PostMapping("/shop/remove/{productId}")
    public void removeProductFromCart(@PathVariable Long productId) {
        cartService.removeProductFromCart(productId);
    }

    @PostMapping("/shop/chekOut")
    public String chekOut(){
        return cartService.checkOut();
    }

    @GetMapping("/shop/list")
    public Cart bringCart(){
        return  cartService.findCartById();
    }
}
