package com.ivvysoft.shop.model.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private Long productId;
    private String productName;
    private Long quantity;
    private Double cost;
}
