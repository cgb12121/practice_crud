package com.backend.practice.model.dto;

import com.backend.practice.model.entity.bill.entity.PaymentMethod;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link PaymentMethod}
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class PaymentMethodDto implements Serializable {
    Integer id;
    String methodName;
}