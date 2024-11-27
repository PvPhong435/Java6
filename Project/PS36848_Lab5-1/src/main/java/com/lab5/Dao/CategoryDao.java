package com.lab5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab5.Model.Categories;

public interface CategoryDao extends JpaRepository<Categories, String> {

}
