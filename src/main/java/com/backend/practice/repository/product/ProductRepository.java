package com.backend.practice.repository.product;

import com.backend.practice.model.entity.product.entity.Product;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @NonNull
    Page<Product> findAll(@NonNull Pageable pageable);

    Product findByProductName(String name);
}
