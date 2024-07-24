//package com.backend.practice.util.dump.service.impl;
//
//import com.backend.practice.model.dto.OrderDto;
//import com.backend.practice.model.entity.bill.entity.Order;
//import com.backend.practice.repository.payment.OrderRepository;
//import com.backend.practice.util.dump.service.OrderService;
//import com.backend.practice.util.mapper.OrderMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//@Service
//public class OrderServiceImpl implements OrderService {
//
//    @Autowired
//    private OrderRepository orderRepository;
//
//    @Autowired
//    private OrderMapper orderMapper;
//
//    @Override
//    public List<OrderDto> getAllOrders() {
//        return orderRepository.findAll()
//                .stream()
//                .map(orderMapper::toDto)
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public Optional<OrderDto> getOrderById(Integer id) {
//        return orderRepository.findById(id)
//                .map(orderMapper::toDto);
//    }
//
//    @Override
//    public OrderDto createOrder(OrderDto orderDto) {
//        Order order = orderMapper.toEntity(orderDto);
//        return orderMapper.toDto(orderRepository.save(order));
//    }
//
//    @Override
//    public OrderDto updateOrder(Integer id, OrderDto orderDto) {
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//        orderMapper.updateEntityFromDto(orderDto, order);
//        return orderMapper.toDto(orderRepository.save(order));
//    }
//
//    @Override
//    public void deleteOrder(Integer id) {
//        Order order = orderRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("Order not found"));
//        orderRepository.delete(order);
//    }
//}
