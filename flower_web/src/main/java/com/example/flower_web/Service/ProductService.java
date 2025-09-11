package com.example.flower_web.Service;

import com.example.flower_web.Models.Product;
import com.example.flower_web.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
    }

    public void addProduct(String name, double price, double discount, double originalPrice, String imageUrl) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setOriginalPrice(originalPrice);
        product.setImageUrl(imageUrl);

        productRepository.save(product);
    }

    public void updateProduct(Long id, String name, double price, double discount, double originalPrice, String imageUrl) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + id));

        product.setName(name);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setOriginalPrice(originalPrice);
        product.setImageUrl(imageUrl);

        productRepository.save(product);
    }


    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Product not found with ID: " + id));

        productRepository.delete(product);
    }

}
