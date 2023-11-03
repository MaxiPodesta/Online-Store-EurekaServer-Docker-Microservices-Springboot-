package com.mp.ar.products.controller;



import com.mp.ar.products.domain.Products;
import com.mp.ar.products.service.IProductService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
@RequestMapping(value = "/products", method = RequestMethod.POST)

public class ProductsController {


    @Autowired
    private IProductService productServ;


    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> saveProduct(@RequestBody Products product) {
        try {
            String resultMessage = productServ.saveProducts(product);
            return ResponseEntity.ok("Product created successfully: " + resultMessage);
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Couldn't create the product: " + e.getMessage());
        }
    }

    @GetMapping("/bringAll")
    @ResponseStatus(HttpStatus.OK)
    public List<Products> getProducts() {
        return productServ.getProducts();
    }

    //3- Delete product
    @DeleteMapping("/delete/{idProduct}")
    public String deleteProducts(@PathVariable Long idProduct) {

        productServ.deleteProducts(idProduct);

        return "Product has been deleted successfully";
    }
    @GetMapping("/bring/{idProduct}")
    public Products bringProduct(@PathVariable Long idProduct){
        Products product = productServ.findProductsById(idProduct);
        return product;
    }

    //4 - Edit Product
    @PutMapping("/edit/{idProduct}")
    public Products editProduct(@PathVariable Long idProduct,
                                @RequestBody Products editProduct) {

        productServ.editProduct(idProduct, editProduct);
        Products productEdited = productServ.findProductsById(idProduct);

        return productEdited;

    }

}




