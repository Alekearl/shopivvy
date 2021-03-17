package com.ivvysoft.shop.service;

import com.ivvysoft.shop.model.Client;
import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.model.ShoppingCart;

public interface ShoppingCartService {
    void registerNewShoppingCart(Client client);

    void addProductToShoppingCart(ShoppingCart shoppingCart, Product product, Long quantity);

    void removeProductFromShoppingCart(ShoppingCart shoppingCart, Product product);

    void clearShoppingCart(ShoppingCart shoppingCart);

    ShoppingCart getShoppingCartById(Long id);

    ShoppingCart getByClient(Client client);
}
