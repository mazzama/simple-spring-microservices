package com.mazzama.distributedtracing.orderservice.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDetail {

    private String id;
    private String name;
    private Long price;
    private Integer quantity;
}
