package com.store.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.store.Dao.CategoryDao;
import com.store.entity.Category;
import com.store.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	@Autowired
	CategoryDao cdao;
	
	@Override
	public List<Category> findAll()
	{
		return cdao.findAll();
	}
}
