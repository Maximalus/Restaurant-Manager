package com.maximalus.controler;

import com.maximalus.dto.UserDto;
import com.maximalus.dto.converter.UserDtoConverter;
import com.maximalus.model.Outlet;
import com.maximalus.model.Role;
import com.maximalus.model.User;
import com.maximalus.service.impl.OutletServiceImpl;
import com.maximalus.service.impl.RoleServiceImpl;
import com.maximalus.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private RoleServiceImpl roleServiceImpl;
    @Autowired
    private OutletServiceImpl outletServiceImpl;

    @GetMapping("/admin/admin")
    public String getAdminPage(){
        return "admin/admin";
    }

    @GetMapping("/admin/allUsers")
    public String getManageUsersPage(Model model){
        List<UserDto> userDtoList =
                userServiceImpl.findAll()
                        .stream()
                        .filter(user -> !user.equals(getAuthenticatedUser()))
                        .map(UserDtoConverter::toDto).collect(Collectors.toList());
        model.addAttribute("users", userDtoList);
        return "admin/manage/user/allUsers";
    }

    @GetMapping(value = "/admin/editUser")
    public String editUser(Model model, @RequestParam String id){
        Long userId = Long.parseLong(id);
        User user = userServiceImpl.findById(userId);
        UserDto userDto = UserDtoConverter.toDto(user);
        List<String> roleList = roleServiceImpl.findAll().stream().map(Role::getName).collect(Collectors.toList());
        List<String> outletList = outletServiceImpl.findAll().stream().map(Outlet::getName).collect(Collectors.toList());
        model.addAttribute("userDto", userDto);
        model.addAttribute("roles", roleList);
        model.addAttribute("outlets", outletList);
        return "admin/manage/user/editUser";
    }

    @PostMapping(value = "/admin/editUser")
    public String postUser(@RequestParam String id,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String role,
                                        @RequestParam String outlet){
        User user = userServiceImpl.findById(Long.parseLong(id));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Role foundRole = roleServiceImpl.findByName(role);
        Outlet foundOutlet = outletServiceImpl.findByName(outlet);
        user.setRole(foundRole);
        user.setOutlet(foundOutlet);
        userServiceImpl.update(user);
        return "admin/admin";
    }

    @GetMapping(value = "/admin/deleteUser")
    public String deleteUser(@RequestParam("id") String id){
        Long userId = Long.parseLong(id);
        userServiceImpl.deleteById(userId);
        return "admin/manage/user/allUsers";
    }

    private User getAuthenticatedUser(){
        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        User authorizedUser = userServiceImpl.findByEmail(username);
        return authorizedUser;
    }
}
