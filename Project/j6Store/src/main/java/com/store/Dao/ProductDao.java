package com.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Product;

public interface ProductDao extends JpaRepository<Product, Integer> {

}
