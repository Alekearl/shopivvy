package com.ivvysoft.shop.service.impl;

import com.ivvysoft.shop.model.Client;
import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.model.ShoppingCart;
import com.ivvysoft.shop.repository.ProductRepository;
import com.ivvysoft.shop.repository.ShoppingCartRepository;
import com.ivvysoft.shop.service.ShoppingCartService;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    private final ShoppingCartRepository shoppingCartRepository;
    private final ProductRepository productRepository;

    @Autowired
    public ShoppingCartServiceImpl(ShoppingCartRepository shoppingCartRepository,
                                   ProductRepository productRepository) {
        this.shoppingCartRepository = shoppingCartRepository;
        this.productRepository = productRepository;
    }

    @Override
    public void registerNewShoppingCart(Client client) {
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.setClient(client);
        shoppingCart.setProducts(new ArrayList<>());
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void addProductToShoppingCart(ShoppingCart shoppingCart,
                                         Product product, Long quantity) {
        if (quantity > productRepository.findById(product.getId()).get().getQuantity()) {
            throw new RuntimeException("Not enough products of " + product.getProductName()
            + ", left only" + productRepository.findById(product.getId()).get().getQuantity());
        }
        product.setQuantity(quantity);
        shoppingCart.getProducts().add(product);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void removeProductFromShoppingCart(ShoppingCart shoppingCart, Product product) {
        shoppingCart.getProducts().remove(product);
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public void clearShoppingCart(ShoppingCart shoppingCart) {
        shoppingCart.getProducts().clear();
        shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart getShoppingCartById(Long id) {
        return shoppingCartRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cant find shopping cart by id "
                + id + "."));
    }

    @Override
    public ShoppingCart getByClient(Client client) {
        return shoppingCartRepository.getShoppingCartByClient(client);
    }
}
