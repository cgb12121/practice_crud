package com.backend.practice.service.impl;

import com.backend.practice.model.dto.OrderDetailDto;
import com.backend.practice.model.entity.bill.entity.OrderDetail;
import com.backend.practice.model.entity.bill.entity.OrderDetailId;
import com.backend.practice.repository.payment.OrderDetailRepository;
import com.backend.practice.service.OrderDetailService;
import com.backend.practice.util.mapper.OrderDetailMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderDetailServiceImpl implements OrderDetailService {

    private final OrderDetailRepository orderDetailRepository;

    private final OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetailDto> getAllOrderDetails() {
        return orderDetailRepository.findAll()
                .stream()
                .map(orderDetailMapper::toDto)
                .toList();
    }

    @Override
    public Optional<OrderDetailDto> getOrderDetailById(OrderDetailId id) {
        return orderDetailRepository.findById(id)
                .map(orderDetailMapper::toDto);
    }

    @Override
    public OrderDetailDto createOrderDetail(OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = orderDetailMapper.toEntity(orderDetailDto);
        return orderDetailMapper.toDto(orderDetailRepository.save(orderDetail));
    }

    @Override
    public OrderDetailDto updateOrderDetail(OrderDetailId id, OrderDetailDto orderDetailDto) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));
        orderDetailMapper.updateEntityFromDto(orderDetailDto, orderDetail);
        return orderDetailMapper.toDto(orderDetailRepository.save(orderDetail));
    }

    @Override
    public void deleteOrderDetail(OrderDetailId id) {
        OrderDetail orderDetail = orderDetailRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("OrderDetail not found"));
        orderDetailRepository.delete(orderDetail);
    }
}
