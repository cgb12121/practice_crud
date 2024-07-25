package com.backend.practice.model.entity.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "supplier")
public class Supplier {
    @Id
    @Column(name = "supplier_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "supplier_name", length = 50)
    private String supplierName;

    @Column(name = "supplier_phone", length = 20)
    private String supplierPhone;

    @Column(name = "supplier_email", length = 100)
    private String supplierEmail;

}