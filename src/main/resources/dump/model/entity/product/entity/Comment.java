//package com.backend.practice.dump.model.entity.product.entity;
//
//import com.backend.practice.dump.model.entity.user.User;
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//import org.hibernate.annotations.ColumnDefault;
//
//import java.time.Instant;
//
//@Getter
//@Setter
//@Entity
//@Table(name = "comments")
//public class Comment {
//    @Id
//    @Column(name = "comment_id", nullable = false)
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Integer id;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
//    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "product_id")
//    private Product product;
//
//    @Lob
//    @Column(name = "comment_text")
//    private String commentText;
//
//    @ColumnDefault("CURRENT_TIMESTAMP")
//    @Column(name = "created_date")
//    private Instant createdDate;
//
//}