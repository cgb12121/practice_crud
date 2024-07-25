package com.backend.practice.model.entity.product.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;
import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "product_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "product_name", nullable = false, length = 50)
    private String productName;

    @Column(name = "product_price", nullable = false, precision = 10, scale = 2)
    private BigDecimal productPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_color_id")
    private Color productColor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_size_id")
    private Size productSize;

    @ColumnDefault("0")
    @Column(name = "is_discount")
    private Boolean isDiscount;

    @Column(name = "discount_percentage", precision = 5, scale = 2)
    private BigDecimal discountPercentage;

    @ColumnDefault("(case when `is_discount` then (`product_price` - ((`product_price` * `discount_percentage`) / 100)) else `product_price` end)")
    @Column(name = "product_discounted_price", precision = 10, scale = 2)
    private BigDecimal productDiscountedPrice;

    @Lob
    @Column(name = "product_thumbnail")
    private String productThumbnail;

    @Lob
    @Column(name = "product_images")
    private String productImages;

    @Lob
    @Column(name = "product_description")
    private String productDescription;

    @Lob
    @Column(name = "product_details")
    private String productDetails;

    @Lob
    @Column(name = "product_maintain")
    private String productMaintain;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @Column(name = "created_by", length = 100)
    private String createdBy;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_date")
    private Instant createdDate;

    @Column(name = "updated_by", length = 100)
    private String updatedBy;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "updated_date")
    private Instant updatedDate;

}