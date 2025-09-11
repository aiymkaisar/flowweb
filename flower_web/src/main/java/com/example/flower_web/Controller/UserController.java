package com.example.flower_web.Controller;

import com.example.flower_web.Models.User;
import com.example.flower_web.Service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService usersService;

    public UserController(UserService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        model.addAttribute("registerRequest", new User());
        return "signin";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        model.addAttribute("loginRequest", new User());
        return "login";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("registerRequest") User usersModel) {
        System.out.println("Register request: " + usersModel);
        User registeredUser = usersService.registerUser(
                usersModel.getLogin(),
                usersModel.getPassword(),
                usersModel.getEmail()
        );
        return registeredUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("loginRequest") User usersModel, Model model) {
        System.out.println("Login request: " + usersModel);
        User authenticated = usersService.authenticate(usersModel.getLogin(), usersModel.getPassword());
        if (authenticated != null) {
            model.addAttribute("userLogin", authenticated.getLogin());
            return "details";
        } else {
            model.addAttribute("error", "Invalid login or password");
            return "login";
        }
    }
}
