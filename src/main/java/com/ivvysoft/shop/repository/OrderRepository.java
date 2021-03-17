package com.ivvysoft.shop.repository;

import com.ivvysoft.shop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
