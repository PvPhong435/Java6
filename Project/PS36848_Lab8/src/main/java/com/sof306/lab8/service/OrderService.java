package com.sof306.lab8.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.sof306.lab8.entity.Order;

import java.util.List;

public interface OrderService {

    /**
     * Creates an order from the given JSON data.
     *
     * @param node the JSON data
     * @return the created order
     */
    Order create(JsonNode node);

    /**
     * Finds an order by ID
     *
     * @param id order ID
     * @return order with the specific ID, or null if not found
     */
    Order findById(int id);

    /**
     * Finds all orders by account username
     *
     * @param username username of account
     * @return a list of orders from that account
     */
    List<Order> findAllByUsername(String username);

}
