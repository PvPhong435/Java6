package com.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Category;

public interface CategoryDao extends JpaRepository< Category, String> {

}
