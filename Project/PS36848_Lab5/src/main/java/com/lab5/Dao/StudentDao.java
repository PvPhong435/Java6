package com.lab5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab5.Model.Student;

public interface StudentDao extends JpaRepository<Student, String> {

}
