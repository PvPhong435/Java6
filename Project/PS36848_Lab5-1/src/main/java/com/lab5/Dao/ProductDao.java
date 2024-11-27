package com.lab5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab5.Model.Products;

public interface ProductDao extends JpaRepository<Products, String> {

}
