package com.ivvysoft.shop.repository;

import com.ivvysoft.shop.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("FROM Product p where p.productName LIKE :template")
    List<Product> findAllProductsByTemplate(String template);
}
