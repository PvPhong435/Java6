package com.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.Order;

public interface OrderDao extends JpaRepository<Order, String> {

}
