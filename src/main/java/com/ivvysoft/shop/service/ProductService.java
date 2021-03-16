package com.ivvysoft.shop.service;

import com.ivvysoft.shop.model.Product;
import java.util.List;

public interface ProductService {
    List<Product> getAllByTemplate(String template);
}
