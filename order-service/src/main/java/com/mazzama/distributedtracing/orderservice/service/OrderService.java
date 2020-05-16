package com.mazzama.distributedtracing.orderservice.service;

import com.mazzama.distributedtracing.orderservice.model.Order;
import com.mazzama.distributedtracing.orderservice.payload.OrderRequest;

import java.util.List;

public interface OrderService {
    List findOrderByUserId(String userId);

    Order save(OrderRequest orderRequest);

    Order findOrderById(String id);
}
