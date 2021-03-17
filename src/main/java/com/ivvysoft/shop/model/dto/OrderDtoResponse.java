package com.ivvysoft.shop.model.dto;

import java.util.List;
import lombok.Data;

@Data
public class OrderDtoResponse {
    private Long id;
    private String clientName;
    private List<String> productName;
    private Double totalPrice;
}
