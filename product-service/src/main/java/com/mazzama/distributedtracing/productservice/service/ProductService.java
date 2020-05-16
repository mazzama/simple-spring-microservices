package com.mazzama.distributedtracing.productservice.service;

import com.mazzama.distributedtracing.productservice.model.Product;
import com.mazzama.distributedtracing.productservice.payload.request.ProductRequest;

import java.util.List;

public interface ProductService {

    Product add(ProductRequest productRequest);

    Product findById(String id);

    List<Product> findAll();
}
