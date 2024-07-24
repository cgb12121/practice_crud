package com.backend.practice.repository.payment;

import com.backend.practice.model.entity.bill.entity.OrderDetail;
import com.backend.practice.model.entity.bill.entity.OrderDetailId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDetailRepository extends JpaRepository<OrderDetail, OrderDetailId> {
}
