package com.maximalus.controler;

import com.maximalus.dto.UserDto;
import com.maximalus.dto.converter.UserDtoConverter;
import com.maximalus.model.Role;
import com.maximalus.model.User;
import com.maximalus.service.RoleService;
import com.maximalus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping("/admin/admin")
    public String getAdmin(){
        return "admin/admin";
    }

    @GetMapping("/admin/allUsers")
    public String getManageUsersPage(Model model){
        return "admin/manage/user/allUsers";
    }

    @ModelAttribute("users")
    public List<UserDto> getAllUsers(){
        List<UserDto> userDtoList =
                userService.findAll()
                        .stream().map(UserDtoConverter::toDto).collect(Collectors.toList());
        return userDtoList;
    }

    @GetMapping(value = {"/admin/editUser", "/admin/editUser/{id}"})
    public String editUser(Model model, @RequestParam("id") Long id){
        User user = userService.findById(id);
        List<Role> roles = roleService.findAll();
        model.addAttribute("user", user);
        model.addAttribute("roles", roles);
        return "admin/manage/user/editUser";
    }

    @PostMapping(value = {"/admin/editUser", "/admin/editUser/{id}"})
    public String postUser(User user){
        userService.update(user);
        return "admin/manage/user/allUsers";
    }

    @GetMapping(value = {"/admin/deleteUser", "/admin/deleteUser/{id}"})
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "admin/manage/user/allUsers";
    }

    private User getAuthenticatedUser(){
        StringBuffer stringBuffer = new StringBuffer();
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
