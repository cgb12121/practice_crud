package com.backend.practice.model.dto;

import com.backend.practice.model.entity.bill.entity.Bill;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

/**
 * DTO for {@link Bill}
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BillDto implements Serializable {
    Integer id;
    OrderDto order;
    UserDto user;
    BigDecimal totalAmount;
    Instant billDate;
    LocalDate estimatedDeliveryDate;
    Boolean isPaid;
    Boolean isDelivered;
    ShippingCompanyDto shippingCompany;
}
