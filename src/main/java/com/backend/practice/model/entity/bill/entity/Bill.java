package com.backend.practice.model.entity.bill.entity;

import com.backend.practice.model.entity.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "bills")
public class Bill {
    @Id
    @Column(name = "bill_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    private BigDecimal totalAmount;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "bill_date")
    private Instant billDate;

    @Column(name = "estimated_delivery_date")
    private LocalDate estimatedDeliveryDate;

    @ColumnDefault("0")
    @Column(name = "is_paid")
    private Boolean isPaid;

    @ColumnDefault("0")
    @Column(name = "is_delivered")
    private Boolean isDelivered;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shipping_company_id")
    private ShippingCompany shippingCompany;

}