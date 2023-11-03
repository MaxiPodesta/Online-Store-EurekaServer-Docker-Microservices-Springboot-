package com.mp.ar.products.service;

import com.mp.ar.products.domain.Products;
import com.mp.ar.products.repository.IProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Slf4j
@Transactional

public class ProductService implements IProductService {
    @Autowired
    private IProductRepository prodRepo;//Injection of the Repository

    @Override
    public List<Products> getProducts() {
        return prodRepo.findAll();
    } //List al the products in the DB

    @Override
    public String saveProducts(Products prod) throws Exception {
        prodRepo.save(prod);
        return "The product has been saved successfully";
    }

    @Override
    public String deleteProducts(Long idProduct) {
        prodRepo.deleteById(idProduct);
        return "Product successfully removed from the list";
    }

    @Override
    public void editProduct(Long idProduct, Products prod) {
        Products existingProduct = prodRepo.findById(idProduct).orElse(null);
        if (existingProduct != null) {
            existingProduct.setNameProduct(prod.getNameProduct());
            existingProduct.setBrand(prod.getBrand());
            existingProduct.setPrice(prod.getPrice());
            prodRepo.save(existingProduct);
        }
    }

    @Override
    public Products findProductsById(Long idProduct) {
        return prodRepo.findById(idProduct).orElse(null);
    }
}
