package com.mazzama.distributedtracing.orderservice.model;

import com.mazzama.distributedtracing.orderservice.payload.Product;
import com.mazzama.distributedtracing.orderservice.payload.ProductDetail;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "orders")
public class Order {

    @Id
    private String id;
    private ProductDetail product;
    private String userId;
}
