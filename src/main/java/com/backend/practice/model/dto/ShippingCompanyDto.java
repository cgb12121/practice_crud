package com.backend.practice.model.dto;

import com.backend.practice.model.entity.bill.entity.ShippingCompany;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link ShippingCompany}
 */
@Data
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShippingCompanyDto implements Serializable {
    Integer id;
    String companyName;
    String companyPhone;
}