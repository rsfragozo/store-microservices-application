package com.atcoffeebreak.orderservice.helpers;

import com.atcoffeebreak.orderservice.dto.OrderLineItemDto;
import com.atcoffeebreak.orderservice.dto.OrderRequest;
import com.atcoffeebreak.orderservice.model.Order;
import com.atcoffeebreak.orderservice.model.OrderLineItem;

import java.util.List;
import java.util.UUID;

public class OrderMapper {

    public static Order mapToOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        List<OrderLineItem> orderLineItems = orderRequest.getOrderLineItems().stream()
                .map(OrderMapper::mapToOrderLineItem)
                .toList();
        order.setOrderLineItems(orderLineItems);

        return order;
    }

    private static OrderLineItem mapToOrderLineItem(OrderLineItemDto orderLineItemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());

        return orderLineItem;
    }
}
