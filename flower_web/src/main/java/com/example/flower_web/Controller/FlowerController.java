package com.example.flower_web.Controller;

import com.example.flower_web.Models.Product;
import com.example.flower_web.Service.OrderService;
import com.example.flower_web.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class FlowerController {

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    // Главная страница
    @GetMapping("/flower")
    public String flowerPage(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "flower";
    }

    // Обработка перехода на /products
    @GetMapping("/products")
    public String productsPage(Model model) {
        model.addAttribute("product", productService.getAllProducts());
        return "flower"; // Возвращаем ту же страницу
    }
    @GetMapping("/contact-us")
    public String contactPage(Model model) {
        model.addAttribute("contact-us", productService.getAllProducts());
        return "flower"; // Возвращаем ту же страницу
    }

    // Добавление товара в корзину
    @GetMapping("/add-to-cart/{productId}")
    public String addToCart(@PathVariable Long productId) {
        Product product = productService.getProductById(productId);

        orderService.addProductToOrder(product);

        return "redirect:/cart";
    }
}
