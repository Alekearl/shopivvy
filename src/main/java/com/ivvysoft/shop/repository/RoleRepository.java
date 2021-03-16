package com.ivvysoft.shop.repository;

import com.ivvysoft.shop.model.Role;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> getRoleByRole(String role);
}
