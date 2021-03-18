package com.ivvysoft.shop.service;

import com.ivvysoft.shop.model.Client;

public interface ClientService {
    Client add(Client user);

    Client get(Long id);

    Client findByEmail(String email);
}
