package com.backend.practice.util.mapper;

import com.backend.practice.model.dto.OrderDto;
import com.backend.practice.model.entity.bill.entity.Order;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);

    void updateEntityFromDto(OrderDto orderDto, @MappingTarget Order order);
}
