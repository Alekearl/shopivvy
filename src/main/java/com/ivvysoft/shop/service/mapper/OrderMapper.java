package com.ivvysoft.shop.service.mapper;

import com.ivvysoft.shop.model.Order;
import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.model.dto.OrderDtoResponse;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    public OrderDtoResponse mapToDto(Order order) {
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
        orderDtoResponse.setId(order.getId());
        orderDtoResponse.setClientName(order.getClient().getEmail());
        List<String> productNames = order.getProducts().stream()
                .map(Product::getProductName)
                .collect(Collectors.toList());
        orderDtoResponse.setProductName(productNames);
        orderDtoResponse.setTotalPrice(order.getTotalPrice());
        return orderDtoResponse;
    }
}
