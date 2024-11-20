package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.entity.Product;


public interface ProductService {

	List<Product> findAll();

}
