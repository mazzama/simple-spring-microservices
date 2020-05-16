package com.mazzama.distributedtracing.orderservice.client;

import com.mazzama.distributedtracing.orderservice.payload.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service")
public interface ProductClient {

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id);
}
