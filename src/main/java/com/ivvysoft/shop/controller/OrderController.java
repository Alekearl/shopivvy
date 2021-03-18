package com.ivvysoft.shop.controller;

import com.ivvysoft.shop.model.Client;
import com.ivvysoft.shop.model.Order;
import com.ivvysoft.shop.model.ShoppingCart;
import com.ivvysoft.shop.model.dto.OrderDtoResponse;
import com.ivvysoft.shop.service.ClientService;
import com.ivvysoft.shop.service.OrderService;
import com.ivvysoft.shop.service.ShoppingCartService;
import com.ivvysoft.shop.service.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;
    private final OrderMapper orderMapper;
    private final ShoppingCartService shoppingCartService;
    private final ClientService clientService;

    @Autowired
    public OrderController(OrderService orderService,
                           OrderMapper orderMapper,
                           ShoppingCartService shoppingCartService,
                           ClientService clientService) {
        this.orderService = orderService;
        this.orderMapper = orderMapper;
        this.shoppingCartService = shoppingCartService;
        this.clientService = clientService;
    }

    @PostMapping("/complete")
    public ResponseEntity<OrderDtoResponse> completeOrder(Authentication authentication) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String username = userDetails.getUsername();
        Client client = clientService.findByEmail(username);
        ShoppingCart shoppingCart = shoppingCartService.getByClient(client);
        Order order = orderService.completeOrder(shoppingCart);
        return new ResponseEntity<>(orderMapper.mapToDto(order), HttpStatus.OK);
    }
}
