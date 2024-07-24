package com.backend.practice.model.dto;

import com.backend.practice.model.entity.bill.entity.Order;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * DTO for {@link Order}
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDto implements Serializable {
    Integer id;
    UserDto user;
    LocalDate orderDate;
    List<OrderDetailDto> orderDetails;
}