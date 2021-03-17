package com.ivvysoft.shop.service.mapper;

import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.model.ShoppingCart;
import com.ivvysoft.shop.model.dto.ShoppingCartResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class ShoppingCartMapper {
    public ShoppingCartResponseDto mapToDto(ShoppingCart shoppingCart) {
        ShoppingCartResponseDto responseDto = new ShoppingCartResponseDto();
        responseDto.setShoppingCartId(shoppingCart.getId());
        List<String> productNames = shoppingCart.getProducts().stream()
                .map(Product::getProductName)
                .collect(Collectors.toList());
        responseDto.setProductNames(productNames);
        return responseDto;
    }
}
