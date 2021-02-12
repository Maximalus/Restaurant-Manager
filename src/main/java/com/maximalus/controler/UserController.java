package com.maximalus.controler;

import com.maximalus.model.User;
import com.maximalus.service.RoleService;
import com.maximalus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;


    @GetMapping("/registration")
    public String showRegistrationForm(User user){
        return "registration";
    }

    @PostMapping("/registration")
    public String saveUser(User user, BindingResult bindingResult, Model model){
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

    @GetMapping("/admin/admin")
    public String getAdmin(){
        return "admin/admin";
    }

    @GetMapping("/403")
    public String loginError(Model model) {
        return "403";
    }

    @GetMapping("/admin/manage/users")
    public String getManageUsersPage(Model model){
        model.addAttribute("users", userService.getAll());
        return "admin/manage/users";
    }

    @GetMapping(value = {"editUser", "/editUser/{id}"})
    public String editUser(Model model, @PathVariable("id") Long id){
        model.addAttribute("user", userService.getOne(id));
        model.addAttribute("roles", roleService.findAll());
        return "admin/manage/editUser";
    }

    @PostMapping(value = {"editUser", "/editUser/{id}"})
    public String postUser(User user){
        userService.update(user);
        return "admin/manage/users";
    }

    @GetMapping(value = {"deleteUser", "deleteUser/{id}"})
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "admin/manage/users";
    }

    private User getAuthenticatedUser(){
        StringBuffer stringBuffer = new StringBuffer();
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
