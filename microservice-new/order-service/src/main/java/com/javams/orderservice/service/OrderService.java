package com.javams.orderservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javams.orderservice.dto.OrderLineItemDto;
import com.javams.orderservice.dto.OrderRequest;
import com.javams.orderservice.model.Order;
import com.javams.orderservice.model.OrderLineItem;
import com.javams.orderservice.repository.OrderRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());

        List<OrderLineItem> items = orderRequest.getOrderLineItemsDto().stream().map(this::mapFromDto).toList();
        order.setOrderLineItems(items);

        orderRepository.save(order);
    }

    private OrderLineItem mapFromDto(OrderLineItemDto orderLineItemDto) {
        OrderLineItem orderLineItem = new OrderLineItem();
        orderLineItem.setPrice(orderLineItemDto.getPrice());
        orderLineItem.setQuantity(orderLineItemDto.getQuantity());
        orderLineItem.setSkuCode(orderLineItemDto.getSkuCode());
        return orderLineItem;
    }

}
