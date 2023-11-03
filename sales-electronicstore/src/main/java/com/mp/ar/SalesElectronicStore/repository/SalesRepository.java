package com.mp.ar.SalesElectronicStore.repository;

import com.mp.ar.SalesElectronicStore.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {
}
