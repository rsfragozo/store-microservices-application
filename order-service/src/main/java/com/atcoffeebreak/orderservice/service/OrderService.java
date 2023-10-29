package com.atcoffeebreak.orderservice.service;

import com.atcoffeebreak.orderservice.dto.OrderRequest;
import com.atcoffeebreak.orderservice.helpers.OrderMapper;
import com.atcoffeebreak.orderservice.model.Order;
import com.atcoffeebreak.orderservice.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class OrderService {

    private final OrderRepository orderRepository;
    public void placeOrder(OrderRequest orderRequest) {
        Order order = OrderMapper.mapToOrder(orderRequest);
        orderRepository.save(order);
    }
}
