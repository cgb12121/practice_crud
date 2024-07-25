package com.backend.practice.model.entity.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "color")
public class Color {
    @Id
    @Column(name = "color_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "color_name", nullable = false, length = 50)
    private String colorName;

}