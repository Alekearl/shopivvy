package com.ivvysoft.shop.controller;

import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.model.ShoppingCart;
import com.ivvysoft.shop.service.ProductService;
import com.ivvysoft.shop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shopping-carts")
public class ShoppingCartController {
    private final ShoppingCartService shoppingCartService;
    private final ProductService productService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService,
                                  ProductService productService) {
        this.shoppingCartService = shoppingCartService;
        this.productService = productService;
    }

    @GetMapping("/{cartId}")
    public ResponseEntity<ShoppingCart> addProductToCart(@PathVariable Long cartId,
                                           @RequestParam Long productId,
                                           @RequestParam Long quantity) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(cartId);
        Product product = productService.getProductById(productId);
        shoppingCartService.addProductToShoppingCart(shoppingCart, product, quantity);
        return new ResponseEntity<>(shoppingCartService.getShoppingCartById(cartId), HttpStatus.OK);
    }

    @DeleteMapping("/{cartId}")
    public ResponseEntity<ShoppingCart> removeProductFromCart(@PathVariable Long cartId,
                                      @RequestParam Long productId) {
        ShoppingCart shoppingCart = shoppingCartService.getShoppingCartById(cartId);
        Product product = productService.getProductById(productId);
        shoppingCartService.removeProductFromShoppingCart(shoppingCart, product);
        return new ResponseEntity<>(shoppingCartService.getShoppingCartById(cartId), HttpStatus.OK);
    }
}
