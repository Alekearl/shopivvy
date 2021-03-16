package com.ivvysoft.shop.service;

import com.ivvysoft.shop.model.Client;

public interface AuthenticationService {
    Client register(String email, String password);
}
