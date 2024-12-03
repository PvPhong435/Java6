package com.sof306.lab8.repository;

import com.sof306.lab8.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductDao extends JpaRepository<Product, String> {

    List<Product> findAllByCategoryId(String categoryId);
    Page<Product> findAllByCategoryId(String categoryId,Pageable pageable);
    Page<Product> findAll(Pageable pageable);

}
