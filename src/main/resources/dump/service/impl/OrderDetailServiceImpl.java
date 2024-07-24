//package com.backend.practice.util.dump.service.impl;
//
//import com.backend.practice.model.dto.OrderDetailDto;
//import com.backend.practice.model.entity.bill.entity.OrderDetail;
//import com.backend.practice.model.entity.bill.entity.OrderDetailId;
//import com.backend.practice.repository.payment.OrderDetailRepository;
//import com.backend.practice.util.dump.service.OrderDetailService;
//import com.backend.practice.util.mapper.OrderDetailMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class OrderDetailServiceImpl implements OrderDetailService {
//
//    @Autowired
//    private OrderDetailRepository orderDetailRepository;
//
//    @Autowired
//    private OrderDetailMapper orderDetailMapper;
//
//    @Override
//    public List<OrderDetailDto> getAllOrderDetails() {
//        return orderDetailRepository.findAll()
//                .stream()
//                .map(orderDetailMapper::toDto)
//                .toList();
//    }
//
//    @Override
//    public Optional<OrderDetailDto> getOrderDetailById(OrderDetailId id) {
//        return orderDetailRepository.findById(id)
//                .map(orderDetailMapper::toDto);
//    }
//
//    @Override
//    public OrderDetailDto createOrderDetail(OrderDetailDto orderDetailDto) {
//        OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDto);
//        return orderDetailMapper.toDto(orderDetailRepository.save(orderDetail));
//    }
//
//    @Override
//    public OrderDetailDto updateOrderDetail(OrderDetailId id, OrderDetailDto orderDetailDto) {
//        OrderDetail orderDetail = orderDetailRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));
//        orderDetailMapper.updateEntityFromDto(orderDetailDto, orderDetail);
//        return orderDetailMapper.toDto(orderDetailRepository.save(orderDetail));
//    }
//
//    @Override
//    public void deleteOrderDetail(OrderDetailId id) {
//        OrderDetail orderDetail = orderDetailRepository.findById(id)
//                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));
//        orderDetailRepository.delete(orderDetail);
//    }
//}
