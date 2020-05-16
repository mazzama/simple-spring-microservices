package com.mazzama.distributedtracing.orderservice.repository;

import com.mazzama.distributedtracing.orderservice.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends MongoRepository<Order, String> {

    List<Order> findAllByUserId(String id);
}
