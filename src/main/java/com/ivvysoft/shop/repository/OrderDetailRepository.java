package com.ivvysoft.shop.repository;

import com.ivvysoft.shop.model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
}
