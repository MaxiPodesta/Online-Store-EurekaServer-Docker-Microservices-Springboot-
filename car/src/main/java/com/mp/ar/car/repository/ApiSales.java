package com.mp.ar.car.repository;

import com.mp.ar.car.DTO.SalesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Repository
@FeignClient(value = "sales-server", name = "sales-server", url = "http://localhost:8085")
public interface ApiSales {
    @PostMapping("/sales/finalize")
    public SalesDTO finalizeSale(@RequestParam Long cartId);
}
