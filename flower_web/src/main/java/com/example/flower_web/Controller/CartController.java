package com.example.flower_web.Controller;

import com.example.flower_web.Models.Product;
import com.example.flower_web.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartController {

    @Autowired
    private OrderService orderService;

    // Отображение корзины
    @GetMapping("/cart")
    public String viewCart(Model model) {
        List<Product> productsInCart = orderService.getProductsInOrder();
        model.addAttribute("orders", productsInCart);
        model.addAttribute("totalAmount", calculateTotal(productsInCart)); // Добавление общей суммы
        return "cart";
    }

    // Удаление товара из корзины
    @GetMapping("/remove-from-cart/{productId}")
    public String removeFromCart(@PathVariable Long productId) {
        orderService.removeProductFromOrder(productId);
        return "redirect:/cart";
    }

    // Обработка данных при оформлении заказа
    @PostMapping("/checkout")
    public String handleCheckout(@RequestParam String name,
                                 @RequestParam String address,
                                 @RequestParam String phone,
                                 @RequestParam String email,
                                 Model model) {
        // Логика обработки данных
        model.addAttribute("customerName", name);
        model.addAttribute("customerAddress", address);
        model.addAttribute("message", "Your order details have been recorded!");
        return "payment"; // Перенаправление на страницу оплаты
    }

    // Фейковая оплата
    @PostMapping("/fake-payment")
    public String processFakePayment(Model model) {
        // Фейковое подтверждение оплаты
        model.addAttribute("message", "Payment successful! Your order is on its way.");
        return "order-confirmation"; // Перенаправление на страницу подтверждения
    }

    // Метод для расчета общей суммы
    private double calculateTotal(List<Product> products) {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }
}
