package com.ivvysoft.shop.service.impl;

import com.ivvysoft.shop.model.Order;
import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.model.ShoppingCart;
import com.ivvysoft.shop.repository.OrderRepository;
import com.ivvysoft.shop.service.OrderService;
import com.ivvysoft.shop.service.ProductService;
import com.ivvysoft.shop.service.ShoppingCartService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository,
                            ShoppingCartService shoppingCartService,
                            ProductService productService) {
        this.orderRepository = orderRepository;
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @Override
    public Order completeOrder(ShoppingCart shoppingCart) {
        Order order = new Order();
        order.setClient(shoppingCart.getClient());
        order.setProducts(new ArrayList<>(shoppingCart.getProducts()));
        double total = 0.0;
        for (Product product : order.getProducts()) {
            total += product.getCost() * product.getQuantity();
        }
        if (order.getClient().getDiscount() != null) {
            order.setTotalPrice(total - total * order.getClient().getDiscount());
        }
        order.setTotalPrice(total);
        orderRepository.save(order);
        shoppingCartService.clearShoppingCart(shoppingCart);
        return order;
    }
}
