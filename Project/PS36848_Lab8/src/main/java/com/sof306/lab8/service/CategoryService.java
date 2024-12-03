package com.sof306.lab8.service;

import com.sof306.lab8.entity.Category;

import java.util.List;

public interface CategoryService {

    /**
     * Return all categories from database
     *
     * @return a list of all categories
     */
    List<Category> findAll();
}
