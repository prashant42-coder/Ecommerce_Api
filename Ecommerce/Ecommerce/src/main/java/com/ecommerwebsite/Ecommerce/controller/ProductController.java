package com.ecommerwebsite.Ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ecommerwebsite.Ecommerce.ProductService;
import com.ecommerwebsite.Ecommerce.entity.Product;

@RestController
@RequestMapping("/api/product") // ✅ Base API path
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getProduct() {
        return productService.getAllProducts();
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {  
         boolean deleted = productService.deleteProduct(id);
         if (deleted) {
            return ResponseEntity.ok("Product deleted successfully");
         } else {
            return ResponseEntity.status(404).body("Product not found");
         }
    }
}
