package com.ivvysoft.shop.security;

import com.ivvysoft.shop.model.Client;
import com.ivvysoft.shop.model.Role;
import com.ivvysoft.shop.repository.ClientRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class CustomerDetailsService implements UserDetailsService {
    private final ClientRepository clientRepository;

    @Autowired
    public CustomerDetailsService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Can't find user by email: "
                        + email + "."));
        List<String> roles = new ArrayList<>();
        for (Role role : client.getRoles()) {
            roles.add(role.getRole());
        }
        User.UserBuilder userBuilder = User.withUsername(client.getEmail());
        userBuilder.password(client.getPassword());
        userBuilder.roles(roles.toArray(new String[0]));
        return userBuilder.build();
    }
}
