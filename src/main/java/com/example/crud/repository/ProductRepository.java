package com.example.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud.model.Product;

public interface ProductRepository extends JpaRepository<Product,Long>{

}
