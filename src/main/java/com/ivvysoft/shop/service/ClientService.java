package com.ivvysoft.shop.service;

import com.ivvysoft.shop.model.Client;
import java.util.Optional;

public interface ClientService {
    Client add(Client user);

    Client get(Long id);

    Optional<Client> findByEmail(String email);
}
