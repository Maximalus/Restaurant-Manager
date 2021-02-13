package com.maximalus.controler;

import com.maximalus.model.User;
import com.maximalus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String showRegistrationForm(User user){
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(User user){
        userService.save(user);
        return "login";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String postLoginPage(){
        return "index";
    }

    @GetMapping("/index")
    public String getIndexPage(){
        return "index";
    }

    @GetMapping("/403")
    public String loginError(Model model) {
        return "403";
    }
}
