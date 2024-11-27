package com.lab5.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lab5.Model.OrderDetails;

public interface OrderDetailDAO extends JpaRepository<OrderDetails, String>{

}
