package com.ivvysoft.shop.model.dto;

import lombok.Data;

@Data
public class ProductRequestDto {
    private String productName;
    private Long quantity;
}
