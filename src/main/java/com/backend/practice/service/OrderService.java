package com.backend.practice.service;

import com.backend.practice.model.dto.OrderDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface OrderService {
    List<OrderDto> getAllOrders();

    Optional<OrderDto> getOrderById(Integer id);

    OrderDto createOrder(OrderDto orderDto);

    OrderDto updateOrder(Integer id, OrderDto orderDto);

    void deleteOrder(Integer id);
}
