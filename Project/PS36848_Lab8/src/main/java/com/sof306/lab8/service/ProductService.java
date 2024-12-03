package com.sof306.lab8.service;

import com.sof306.lab8.entity.Product;

import org.springframework.data.domain.Pageable;
import java.util.List;

import org.springframework.data.domain.Page;

public interface ProductService {

    /**
     * Return all products from database
     *
     * @return a list of all products
     */
    List<Product> findAll();

    /**
     * Finds a product by ID
     *
     * @param id product ID
     * @return product with the specific ID, or null if not found
     */
    Product findById(String id);

    /**
     * Finds products by category ID
     *
     * @param categoryId category ID
     * @return a list of products in that category
     */
    List<Product> findByCategoryId(String categoryId);
    
    Page<Product> findAllByCategoryId(String categoryId,Pageable pageable);
    
    Page<Product> findAll(Pageable pageable);

}
