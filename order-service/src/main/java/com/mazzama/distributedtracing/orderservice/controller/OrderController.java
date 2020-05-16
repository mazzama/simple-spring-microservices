package com.mazzama.distributedtracing.orderservice.controller;

import com.mazzama.distributedtracing.orderservice.model.Order;
import com.mazzama.distributedtracing.orderservice.payload.OrderRequest;
import com.mazzama.distributedtracing.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/")
    public Order getOrderById(@PathVariable("id") String id) {
        return orderService.findOrderById(id);
    }

    @GetMapping("/user/{id}")
    public List getOrderByUserId(@PathVariable("id") String userId) {
        return orderService.findOrderByUserId(userId);
    }

    @PostMapping("/")
    public Order postOrder(@RequestBody OrderRequest orderRequest) {
        return orderService.save(orderRequest);
    }
}
