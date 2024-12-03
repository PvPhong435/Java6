package com.sof306.lab8.impl;

import com.sof306.lab8.entity.Category;
import com.sof306.lab8.repository.CategoryDao;
import com.sof306.lab8.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryDao categoryDao;

    public CategoryServiceImpl(CategoryDao categoryDao) {
        this.categoryDao = categoryDao;
    }

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }
}
