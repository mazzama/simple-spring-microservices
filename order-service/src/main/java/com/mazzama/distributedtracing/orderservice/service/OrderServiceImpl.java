package com.mazzama.distributedtracing.orderservice.service;

import com.mazzama.distributedtracing.orderservice.client.ProductClient;
import com.mazzama.distributedtracing.orderservice.model.Order;
import com.mazzama.distributedtracing.orderservice.payload.OrderRequest;
import com.mazzama.distributedtracing.orderservice.payload.Product;
import com.mazzama.distributedtracing.orderservice.payload.ProductDetail;
import com.mazzama.distributedtracing.orderservice.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductClient productClient;

    @Override
    public List findOrderByUserId(String userId) {
        return orderRepository.findAllByUserId(userId);
    }

    @Override
    public Order save(OrderRequest orderRequest) {

        log.info("Calling Product Service, findById: {}", orderRequest.getProductId());
        Product product = productClient.findById(orderRequest.getProductId());
        ProductDetail  productDetail = ProductDetail.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .quantity(orderRequest.getQuantity())
                .build();

        Order newOder = Order.builder()
                .product(productDetail)
                .userId(orderRequest.getUserId())
                .build();

        log.info("Save new order with user: {} and product: {}", orderRequest.getUserId(), orderRequest.getProductId());
        return orderRepository.save(newOder);
    }

    @Override
    public Order findOrderById(String id) {
        return orderRepository.findById(id).get();
    }
}
