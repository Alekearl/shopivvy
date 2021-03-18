package com.ivvysoft.shop.repository;

import com.ivvysoft.shop.model.Client;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClientRepository extends JpaRepository<Client, Long> {
    @Query("FROM Client c JOIN FETCH c.roles WHERE c.email = :email")
    Optional<Client> findByEmail(String email);
}
