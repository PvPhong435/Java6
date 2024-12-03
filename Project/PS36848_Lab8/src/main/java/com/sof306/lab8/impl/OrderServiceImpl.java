package com.sof306.lab8.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sof306.lab8.entity.Order;
import com.sof306.lab8.entity.OrderDetail;
import com.sof306.lab8.repository.OrderDao;
import com.sof306.lab8.repository.OrderDetailDao;
import com.sof306.lab8.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    OrderDao orderDao;
    OrderDetailDao orderDetailDao;

    public OrderServiceImpl(OrderDao orderDao, OrderDetailDao orderDetailDao) {
        this.orderDao = orderDao;
        this.orderDetailDao = orderDetailDao;
    }

    @Override
    public Order create(JsonNode node) {
        ObjectMapper mapper = new ObjectMapper();
        Order order = mapper.convertValue(node, Order.class);
        System.out.println(node);
        orderDao.save(order);

        TypeReference<List<OrderDetail>> typeRef = new TypeReference<>() {};
        List<OrderDetail> details = mapper.convertValue(node.get("orderDetails"), typeRef).stream()
                .peek(orderDetail -> orderDetail.setOrder(order))
                .toList();
        orderDetailDao.saveAll(details);
        return null;
    }

    @Override
    public Order findById(int id) {
        return orderDao.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAllByUsername(String username) {
        return orderDao.findAllByAccount_Username(username);
    }

}
