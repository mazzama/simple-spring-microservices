package com.mazzama.distributedtracing.productservice.payload.request;

import lombok.Data;

@Data
public class ProductRequest {
    private String name;
    private String category;
    private String seller;
    private Long price;
}
