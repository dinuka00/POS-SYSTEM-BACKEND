package com.ijse.posbackend.service;

import com.ijse.posbackend.dto.OrderDTO;
import com.ijse.posbackend.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {
    List<Order> getAllOrders();
    Order getOrderById(Long id);

    Order createOrder(OrderDTO orderDTO);

}
