package com.sof306.lab8.impl;

import com.sof306.lab8.entity.Product;

import com.sof306.lab8.repository.ProductDao;
import com.sof306.lab8.service.ProductService;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    ProductDao productDao;

    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(String id) {
        return productDao.findById(id).orElse(null);
    }

    @Override
    public List<Product> findByCategoryId(String categoryId) {
        return productDao.findAllByCategoryId(categoryId);
    }
    
    @Override
    public Page<Product> findAllByCategoryId(String categoryId, Pageable pageable) {
        return productDao.findAllByCategoryId(categoryId, pageable);
    }
    
    @Override
    public Page<Product> findAll(Pageable pageable) {
    	// TODO Auto-generated method stub
    	return productDao.findAll(pageable);
    }
}
