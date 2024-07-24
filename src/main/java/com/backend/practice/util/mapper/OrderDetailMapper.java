package com.backend.practice.util.mapper;

import com.backend.practice.model.dto.OrderDetailDto;
import com.backend.practice.model.entity.bill.entity.OrderDetail;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface OrderDetailMapper {
    OrderDetailDto toDto(OrderDetail orderDetail);

    OrderDetail toEntity(OrderDetailDto orderDetailDto);

    void updateEntityFromDto(OrderDetailDto orderDetailDto, @MappingTarget OrderDetail orderDetail);
}