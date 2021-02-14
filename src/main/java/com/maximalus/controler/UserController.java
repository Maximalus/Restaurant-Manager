package com.maximalus.controler;

import com.maximalus.dto.UserDto;
import com.maximalus.dto.converter.UserDtoConverter;
import com.maximalus.model.Outlet;
import com.maximalus.model.Role;
import com.maximalus.model.User;
import com.maximalus.service.OutletService;
import com.maximalus.service.RoleService;
import com.maximalus.service.UserService;
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
    private UserService userService;
    @Autowired
    private RoleService roleService;
    @Autowired
    private OutletService outletService;

    @GetMapping("/admin/admin")
    public String getAdminPage(){
        return "admin/admin";
    }

    @GetMapping("/admin/allUsers")
    public String getManageUsersPage(Model model){
        List<UserDto> userDtoList =
                userService.findAll()
                        .stream().map(UserDtoConverter::toDto).collect(Collectors.toList());
        model.addAttribute("users", userDtoList);
        return "admin/manage/user/allUsers";
    }

    @GetMapping(value = "/admin/editUser")
    public String editUser(Model model, @RequestParam String id){
        Long userId = Long.parseLong(id);
        User user = userService.findById(userId);
        UserDto userDto = UserDtoConverter.toDto(user);
        List<String> roleList = roleService.findAll().stream().map(Role::getName).collect(Collectors.toList());
        List<String> outletList = outletService.findAll().stream().map(Outlet::getName).collect(Collectors.toList());
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
        User user = userService.findById(Long.parseLong(id));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Role foundRole = roleService.findByName(role);
        Outlet foundOutlet = outletService.findByName(outlet);
        user.setRole(foundRole);
        user.setOutlet(foundOutlet);
        userService.update(user);
        return "admin/admin";
    }

    @GetMapping(value = "/admin/deleteUser")
    public String deleteUser(@RequestParam("id") String id){
        Long userId = Long.parseLong(id);
        userService.deleteById(userId);
        return "admin/manage/user/allUsers";
    }

    private User getAuthenticatedUser(){
        StringBuffer stringBuffer = new StringBuffer();
        return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    }
}
