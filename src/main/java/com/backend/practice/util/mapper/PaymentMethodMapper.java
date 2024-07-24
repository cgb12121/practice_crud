package com.backend.practice.util.mapper;

import com.backend.practice.model.dto.PaymentMethodDto;
import com.backend.practice.model.entity.bill.entity.PaymentMethod;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface PaymentMethodMapper {
    PaymentMethodDto toDto(PaymentMethod paymentMethod);

    PaymentMethod toEntity(PaymentMethodDto paymentMethodDto);

    void updateEntityFromDto(PaymentMethodDto paymentMethodDto, @MappingTarget PaymentMethod paymentMethod);
}
