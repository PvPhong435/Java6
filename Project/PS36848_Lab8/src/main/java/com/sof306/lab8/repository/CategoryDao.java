package com.sof306.lab8.repository;

import com.sof306.lab8.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category, String> {



}
