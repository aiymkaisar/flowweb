package com.example.flower_web.Controller;

import com.example.flower_web.Models.Product;
import com.example.flower_web.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AdminController {

    private final ProductService productService;

    public AdminController(ProductService productService) {
        this.productService = productService;
    }

    // Страница админки с отображением всех продуктов
    @GetMapping("/admin")
    public String adminPage(Model model) {
        model.addAttribute("products", productService.getAllProducts()); // Передаем все продукты в модель
        model.addAttribute("newProduct", new Product()); // Для нового продукта
        return "admin"; // Возвращает admin.html
    }

    // Добавление нового продукта
    @PostMapping("/admin/add-product")
    public String addProduct(@ModelAttribute("newProduct") Product product, Model model) {
        try {
            productService.addProduct(
                    product.getName(),
                    product.getPrice(),
                    product.getDiscount(),
                    product.getOriginalPrice(),
                    product.getImageUrl()
            );
            model.addAttribute("success", "Product added successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to add product: " + e.getMessage());
        }
        return "redirect:/admin"; // Перенаправление обратно на страницу администрирования
    }

    // Обновление данных продукта
    @PostMapping("/admin/update-product/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product, Model model) {
        try {
            productService.updateProduct(id, product.getName(), product.getPrice(), product.getDiscount(), product.getOriginalPrice(), product.getImageUrl());
            model.addAttribute("success", "Product updated successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to update product: " + e.getMessage());
        }
        return "redirect:/admin"; // Перенаправление на страницу администрирования
    }

    // Удаление продукта
    @GetMapping("/admin/delete-product/{id}")
    public String deleteProduct(@PathVariable Long id, Model model) {
        try {
            productService.deleteProduct(id);
            model.addAttribute("success", "Product deleted successfully!");
        } catch (Exception e) {
            model.addAttribute("error", "Failed to delete product: " + e.getMessage());
        }
        return "redirect:/admin"; // Перенаправление обратно на страницу администрирования
    }
}