package com.ivvysoft.shop.controller;

import com.ivvysoft.shop.model.Role;
import com.ivvysoft.shop.service.ClientService;
import com.ivvysoft.shop.service.RoleService;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InitializerController {
    private final ClientService clientService;
    private final RoleService roleService;

    @Autowired
    public InitializerController(ClientService clientService,
                                 RoleService roleService) {
        this.clientService = clientService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void inject() {
        Role clientRole = new Role();
        clientRole.setRole("USER");
        roleService.add(clientRole);
    }
}
