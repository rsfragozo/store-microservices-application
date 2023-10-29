package com.atcoffeebreak.orderservice.repository;

import com.atcoffeebreak.orderservice.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
