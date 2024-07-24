//package com.backend.practice.dump.model.dto;
//
//import com.backend.practice.dump.model.entity.product.entity.*;
//import com.backend.practice.util.dump.model.entity.product.entity.*;
//import lombok.Value;
//
//import java.io.Serializable;
//import java.math.BigDecimal;
//import java.time.Instant;
//
///**
// * DTO for {@link Product}
// */
//@Value
//public class ProductDto implements Serializable {
//    Integer id;
//    Category category;
//    String productName;
//    BigDecimal productPrice;
//    Color productColor;
//    Size productSize;
//    Boolean isDiscount;
//    BigDecimal discountPercentage;
//    BigDecimal productDiscountedPrice;
//    String productThumbnail;
//    String productImages;
//    String productDescription;
//    String productDetails;
//    String productMaintain;
//    Brand brand;
//    Supplier supplier;
//    Integer productQuantity;
//    String createdBy;
//    Instant createdDate;
//    String updatedBy;
//    Instant updatedDate;
//}