package com.sof306.lab8.repository;

import com.sof306.lab8.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDao extends JpaRepository<Order, Integer> {

    List<Order> findAllByAccount_Username(String username);

}
