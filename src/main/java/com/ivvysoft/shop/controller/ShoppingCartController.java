package com.ivvysoft.shop.controller;

import com.ivvysoft.shop.model.Client;
import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.model.ShoppingCart;
import com.ivvysoft.shop.service.ClientService;
import com.ivvysoft.shop.service.ProductService;
import com.ivvysoft.shop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;
    private final ClientService clientService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ProductService productService, ClientService clientService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
        this.clientService = clientService;
    }

    @PostMapping("/products/add")
    public void addProductToCart(Authentication authentication,
                                           @RequestParam Long productId,
                                           @RequestParam Long quantity) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String name = userDetails.getUsername();
        Client client = clientService.findByEmail(name);
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(client.getId());
        Product product = productService.getProductById(productId);
        shoppingCartService.addProductToShoppingCart(shoppingCart, product, quantity);
    }

    @DeleteMapping("/products/remove")
    public ResponseEntity<ShoppingCart> removeProductFromCart(Authentication authentication,
                                      @RequestParam Long productId) {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String name = userDetails.getUsername();
        Client client = clientService.findByEmail(name);
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(client.getId());
        Product product = productService.getProductById(productId);
        shoppingCartService.removeProductFromShoppingCart(shoppingCart, product);
        return new ResponseEntity<>(shoppingCartService.getShoppingCartById(client.getId()),
                HttpStatus.OK);
    }
}
