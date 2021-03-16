package com.ivvysoft.shop.controller;

import com.ivvysoft.shop.model.dto.ClientDtoRequest;
import com.ivvysoft.shop.service.AuthenticationService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AuthenticationController {
    private final AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public void registration(@RequestBody @Valid ClientDtoRequest request) {
        authenticationService.register(request.getEmail(), request.getPassword());
    }
}
