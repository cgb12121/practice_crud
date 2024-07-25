package com.backend.practice.model.entity.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "size")
public class Size {
    @Id
    @Column(name = "size_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "size_name", nullable = false, length = 50)
    private String sizeName;

}