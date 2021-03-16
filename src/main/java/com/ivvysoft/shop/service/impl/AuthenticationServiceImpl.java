package com.ivvysoft.shop.service.impl;

import com.ivvysoft.shop.model.Client;
import com.ivvysoft.shop.service.AuthenticationService;
import com.ivvysoft.shop.service.ClientService;
import com.ivvysoft.shop.service.RoleService;
import com.ivvysoft.shop.service.ShoppingCartService;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final ClientService clientService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    @Autowired
    public AuthenticationServiceImpl(ClientService clientService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.clientService = clientService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public Client register(String email, String password) {
        Client client = new Client();
        client.setEmail(email);
        client.setPassword(password);
        client.setRoles(Set.of(roleService.getRoleByName("USER")));
        clientService.add(client);
        shoppingCartService.registerNewShoppingCart(client);
        return client;
    }
}
