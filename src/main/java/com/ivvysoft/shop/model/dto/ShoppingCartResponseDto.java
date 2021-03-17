package com.ivvysoft.shop.model.dto;

import java.util.List;
import lombok.Data;

@Data
public class ShoppingCartResponseDto {
    private Long shoppingCartId;
    private List<String> productNames;
}
