package com.ivvysoft.shop.service.impl;

import com.ivvysoft.shop.model.Client;
import com.ivvysoft.shop.repository.ClientRepository;
import com.ivvysoft.shop.service.ClientService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepository clientRepository;
    private final PasswordEncoder passwordEncoder;

    public ClientServiceImpl(ClientRepository clientRepository, PasswordEncoder passwordEncoder) {
        this.clientRepository = clientRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Client add(Client client) {
        String encodePassword = passwordEncoder.encode(client.getPassword());
        client.setPassword(encodePassword);
        return clientRepository.save(client);
    }

    @Override
    public Client get(Long id) {
        return clientRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Can't find client by id "
                + id + "."));
    }

    @Override
    public Client findByEmail(String email) {
        return clientRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Can't find client by email "
                + email + "."));
    }
}
