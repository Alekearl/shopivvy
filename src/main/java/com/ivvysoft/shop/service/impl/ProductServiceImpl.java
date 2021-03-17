package com.ivvysoft.shop.service.impl;

import com.ivvysoft.shop.model.Product;
import com.ivvysoft.shop.repository.ProductRepository;
import com.ivvysoft.shop.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAllByTemplate(String template) {
        return productRepository
                .findAllProductsByTemplate("%" + template + "%");
    }

    @Override
    public Product getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Cant find pdoduct by id "
                + productId + "."));
    }
}
