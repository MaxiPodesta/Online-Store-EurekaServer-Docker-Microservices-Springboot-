package com.mp.ar.car.repository;

import com.mp.ar.car.DTO.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

@Repository
@FeignClient(value ="product-service",name = "product-service", url = "http://localhost:8083")
public interface ApiProducts {
    @Bean
    @GetMapping("/inventory/{idProduct}")
    public ProductDTO getProductDTO(@Param("idProduct") Long idProduct);
}
