package com.mp.ar.SalesElectronicStore.repository;

import com.mp.ar.SalesElectronicStore.DTO.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Repository
@FeignClient(value= "cart-service" , name = "cart-service", url = "http://localhost:8082")
public interface IApiCart {
    // Define a Feign client to communicate with the 'cart-service'.
    @Bean
    @PostMapping("/cart/shop")
    public CartDTO getCartDetails(@Param("idCart")Long cartId);
    // Create a method to retrieve cart details based on a cart ID.

}
