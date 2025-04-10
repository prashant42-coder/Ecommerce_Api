package com.ecommerwebsite.Ecommerce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerwebsite.Ecommerce.ProductRepository;
import com.ecommerwebsite.Ecommerce.entity.Product;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();  //  Should return all product fields
    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public boolean deleteProduct(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
            return true;

            
        }
        return false;
    }
}
