package com.mp.ar.car.service;

import com.mp.ar.car.DTO.ProductDTO;
import com.mp.ar.car.DTO.SalesDTO;
import com.mp.ar.car.domain.Cart;
import com.mp.ar.car.repository.ApiProducts;
import com.mp.ar.car.repository.ApiSales;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CartService implements ICartService {
    @Getter
    private final Cart cart = new Cart(); // Inicialización del carrito

    @Autowired
    private ApiSales apiSales;
    @Autowired
    private ApiProducts feignClient;
    @Autowired
    RestTemplate apiConsume;

    @Override
    public void addProductToCart(Long productId) {
        ProductDTO product = apiConsume.getForObject("http://localhost:8083/products/bring/"+productId,ProductDTO.class);
        if (product != null) {
            cart.getProductsListOnTheCart().add(product);
            cart.setTotal(cart.getTotal() + product.getPrice());
        }
    }

    @Override
    public void removeProductFromCart(Long productId) {
        cart.getProductsListOnTheCart()
                .removeIf(product -> product.getIdProduct().equals(productId));
    }
    @Override
    public Cart findCartById(){

        return cart;
    }

    @Override
    public String checkOut() {
        Long cartId = getCart().getIdCart();
        SalesDTO finalSale = apiSales.finalizeSale(cartId);
        if (finalSale != null) {
            String date = String.valueOf(finalSale.getSaleDate());
            String id = String.valueOf(finalSale.getIdSale());
            Double total = cart.getTotal();
            return "Date: " + date + " Id: " + id + " Total: " + total;
        } else {
            return "Unable to complete the sale. Please check your cart and try again.";
        }
    }

    // Method to recalculate the cart's total
    private void updateCartTotal() {
        double total = cart.getProductsListOnTheCart().stream()
                .mapToDouble(ProductDTO::getPrice)
                .sum();

        cart.setTotal(total); // Update the total in the cart
    }
}
