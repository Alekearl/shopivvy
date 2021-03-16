package com.ivvysoft.shop.service.impl;

import com.ivvysoft.shop.model.Role;
import com.ivvysoft.shop.repository.RoleRepository;
import com.ivvysoft.shop.service.RoleService;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public void add(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleRepository.getRoleByRole(roleName)
                .orElseThrow(() -> new NoSuchElementException("Can't find role "
                        + roleName + "."));
    }
}
