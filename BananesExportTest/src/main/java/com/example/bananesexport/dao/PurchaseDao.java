package com.example.bananesexport.dao;

import com.example.bananesexport.model.Costumer;
import com.example.bananesexport.model.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PurchaseDao extends JpaRepository<Purchase, Integer> {
    @Query("SELECT c.purchases FROM Costumer c where c.id =:id")
    List<Purchase> findAllPurchases(@Param("id") int id);
}
