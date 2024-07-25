package com.backend.practice.model.entity.bill.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "shipping_company")
public class ShippingCompany {
    @Id
    @Column(name = "company_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "company_name", nullable = false, length = 50)
    private String companyName;

    @Column(name = "company_phone", nullable = false, length = 20)
    private String companyPhone;

}