package com.sof306.lab8.rest.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.sof306.lab8.entity.Order;
import com.sof306.lab8.service.OrderService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {

    OrderService orderService;

    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public Order create(@RequestBody JsonNode node) {
        return orderService.create(node);
    }
}
