package com.example.flower_web.Service;

import com.example.flower_web.Models.Product;
import com.example.flower_web.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final ProductRepository productRepository;

    private List<Product> productsInOrder = new ArrayList<>();

    @Autowired
    public OrderService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProductsInOrder() {
        return productsInOrder;
    }
    public void removeProductFromOrder(Long productId) {
        productsInOrder.removeIf(product -> product.getId().equals(productId));
    }

    public void addProductToOrder(Product product) {
        productsInOrder.add(product);
    }

    public void someMethod() {
        List<Product> products = productRepository.findAll();
        for (Product product : products) {
            Long productId = product.getId();
        }
    }
}
