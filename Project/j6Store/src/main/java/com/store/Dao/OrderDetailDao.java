package com.store.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.store.entity.OrderDetail;

public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

}
