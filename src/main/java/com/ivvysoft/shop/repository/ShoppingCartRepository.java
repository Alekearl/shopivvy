package com.ivvysoft.shop.repository;

import com.ivvysoft.shop.model.Client;
import com.ivvysoft.shop.model.ShoppingCart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    ShoppingCart getShoppingCartByClient(Client client);
}
