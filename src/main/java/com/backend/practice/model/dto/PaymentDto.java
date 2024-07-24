package com.backend.practice.model.dto;

import com.backend.practice.model.entity.bill.entity.Payment;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.Instant;

/**
 * DTO for {@link Payment}
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentDto implements Serializable {
    Integer id;
    OrderDto order;
    Instant paymentDate;
    BigDecimal amount;
    PaymentMethodDto method;
}