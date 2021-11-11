package com.example.bananesexport.dao;

import com.example.bananesexport.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface CostumerDao extends JpaRepository<Costumer, Integer> {

}
