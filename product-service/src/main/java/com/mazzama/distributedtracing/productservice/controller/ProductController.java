package com.mazzama.distributedtracing.productservice.controller;

import com.mazzama.distributedtracing.productservice.model.Product;
import com.mazzama.distributedtracing.productservice.payload.request.ProductRequest;
import com.mazzama.distributedtracing.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/")
    public Product add(@RequestBody ProductRequest productRequest) {
        return productService.add(productRequest);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id) {
        return productService.findById(id);
    }

    @GetMapping("/")
    public List<Product> findAll() {
        return productService.findAll();
    }
}
