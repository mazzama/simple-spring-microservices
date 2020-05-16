package com.mazzama.distributedtracing.productservice.service;

import com.mazzama.distributedtracing.productservice.model.Product;
import com.mazzama.distributedtracing.productservice.payload.request.ProductRequest;
import com.mazzama.distributedtracing.productservice.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product add(ProductRequest productRequest) {
        Product newProduct = Product.builder()
                .name(productRequest.getName())
                .category(productRequest.getCategory())
                .price(productRequest.getPrice())
                .seller(productRequest.getSeller())
                .build();
        log.info("Saving new product: {}", newProduct.getName());
        return productRepository.save(newProduct);
    }

    @Override
    public Product findById(String id) {
        log.info("Searching for product by id: {}", id);
        return productRepository.findById(id).get();
    }

    @Override
    public List<Product> findAll() {
        log.info("Finding all products");
        return productRepository.findAll();
    }
}
