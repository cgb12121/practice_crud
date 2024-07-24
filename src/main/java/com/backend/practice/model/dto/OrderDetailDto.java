package com.backend.practice.model.dto;

import com.backend.practice.model.entity.bill.entity.OrderDetail;
import com.backend.practice.model.entity.bill.entity.OrderDetailId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link OrderDetail}
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderDetailDto implements Serializable {
    OrderDetailId id;
    OrderDto order;
    ProductDto product;
    Integer quantity;
}