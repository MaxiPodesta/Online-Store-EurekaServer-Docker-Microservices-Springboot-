package com.mp.ar.products.service;

import com.mp.ar.products.domain.Products;


import java.util.List;

//interface implemented in Product service Class 
public interface IProductService {

    //Save the products and throws an exception in case something goes wrong 
    String saveProducts(Products prod) throws Exception;
    //List all the products from the DB 
    List<Products> getProducts();
    //Delete the product by id
    String deleteProducts(Long idProduct);
    //find a product by id, and then edit all the properties
    void editProduct(Long idProduct, Products prod);
    //find a product by id
    Products findProductsById(Long idProduct);


}
