package com.ivvysoft.shop.service;

import com.ivvysoft.shop.model.Order;
import com.ivvysoft.shop.model.ShoppingCart;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);
}
