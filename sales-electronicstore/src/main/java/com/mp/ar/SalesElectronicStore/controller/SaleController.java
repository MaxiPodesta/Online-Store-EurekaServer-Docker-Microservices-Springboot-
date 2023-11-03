package com.mp.ar.SalesElectronicStore.controller;

import com.mp.ar.SalesElectronicStore.DTO.SaleDTO;
import com.mp.ar.SalesElectronicStore.domain.Sales;
import com.mp.ar.SalesElectronicStore.service.SaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {
    // This class represents a Spring MVC controller for cart-related operations.
@Autowired
    private final SaleService saleService;
    // Autowired field to inject the SaleService dependency.
    private final static Logger logger = LoggerFactory.getLogger(SaleController.class);
    // Static logger instance for logging.
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }
    // Constructor for initializing the SaleController with SaleService.
    @PostMapping("/finalize")
    public Sales finalizeSale(@RequestParam Long cartId) {
        // Handles POST requests to finalize a sale by passing a cartId.
        return saleService.buy(cartId);
    }
}
