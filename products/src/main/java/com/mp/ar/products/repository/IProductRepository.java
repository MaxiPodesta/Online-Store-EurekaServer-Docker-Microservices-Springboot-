package com.mp.ar.products.repository;

import com.mp.ar.products.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Products, Long> {
}