package com.lab5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab5.Model.Orders;



public interface OrderDAO extends JpaRepository<Orders, String> {

}
