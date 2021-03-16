package com.ivvysoft.shop.service;

import com.ivvysoft.shop.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
