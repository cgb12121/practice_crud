//package com.backend.practice.dump.model.entity.bill.entity;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Embeddable;
//import jakarta.persistence.GeneratedValue;
//import jakarta.persistence.GenerationType;
//import lombok.*;
//
//import java.io.Serial;
//import java.io.Serializable;
//
//@Data
//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor
//@Embeddable
//public class OrderDetailId implements Serializable {
//    @Serial
//    private static final long serialVersionUID = 2873746746774319553L;
//
//    @Column(name = "order_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer orderId;
//
//    @Column(name = "product_id", nullable = false)
//    private Integer productId;
//
//}