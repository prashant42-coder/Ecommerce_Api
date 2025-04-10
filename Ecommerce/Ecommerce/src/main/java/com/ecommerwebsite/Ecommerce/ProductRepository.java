package com.ecommerwebsite.Ecommerce;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerwebsite.Ecommerce.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
