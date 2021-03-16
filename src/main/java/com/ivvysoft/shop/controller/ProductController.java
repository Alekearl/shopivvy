package com.ivvysoft.shop.controller;

import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllByTemplate(@RequestParam String template) {
        List<Product> products = productService.getAllByTemplate(template);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
