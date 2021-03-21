package com.maximalus.controler;

import com.maximalus.dto.UserDto;
import com.maximalus.dto.converter.CredentialDtoConverter;
import com.maximalus.dto.converter.UserDtoConverter;
import com.maximalus.model.Credential;
import com.maximalus.model.Outlet;
import com.maximalus.model.Role;
import com.maximalus.model.User;
import com.maximalus.service.impl.CredentialServiceImpl;
import com.maximalus.service.impl.OutletServiceImpl;
import com.maximalus.service.impl.RoleServiceImpl;
import com.maximalus.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@AllArgsConstructor
public class UserController {
    private UserServiceImpl userService;
    private RoleServiceImpl roleService;
    private OutletServiceImpl outletService;
    private CredentialServiceImpl credentialService;

    @GetMapping("/admin/admin")
    public String getAdminPage(){
        return "admin/admin";
    }

    @GetMapping("/admin/createUser")
    public String getCreateUserPage(Model model){
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("outlets", outletService.getListOfOutletNames());
        model.addAttribute("roles", roleService.getListOfRoleNames());
        return "admin/manage/user/createUser";
    }

    @PostMapping("/admin/createUser")
    public String saveUserAndCredential(@Valid @ModelAttribute("userDto") UserDto userDto,
                                        BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "403";
        }
        Credential credential = CredentialDtoConverter.fromDto(userDto);
        Role role = roleService.findByName(userDto.getRole());
        credential.setRole(role);
        credentialService.save(credential);
        User user = UserDtoConverter.createFromDto(userDto);
        Outlet outlet = outletService.findByName(userDto.getOutlet());
        user.setOutlet(outlet);
        user.setCredential(credential);
        userService.save(user);

        return "admin/admin";
    }

    @GetMapping("/admin/allUsers")
    public String getManageUsersPage(Model model){
        List<UserDto> userDtoList =
                userService.findAll()
                        .stream()
                        .filter(user -> !user.equals(getAuthenticatedUser()))
                        .filter(user -> !user.isDeleted())
                        .map(UserDtoConverter::toDto).collect(Collectors.toList());
        model.addAttribute("users", userDtoList);
        return "admin/manage/user/allUsers";
    }

    @GetMapping(value = "/admin/editUser")
    public String editProfile(Model model, @RequestParam String id){
        Long userId = Long.parseLong(id);
        User user = userService.findById(userId);
        UserDto userDto = UserDtoConverter.toDto(user);
        model.addAttribute("userDto", userDto);
        model.addAttribute("roles", roleService.getListOfRoleNames());
        model.addAttribute("outlets", outletService.getListOfOutletNames());
        return "admin/manage/user/editUser";
    }

    @PostMapping(value = "/admin/editUser")
    public String postProfile(@Valid @ModelAttribute("userDto") UserDto userDto,
                              BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "403";
        }
        User user = userService.findById(userDto.getId());
        Outlet outlet = outletService.findByName(userDto.getOutlet());
        Role role = roleService.findByName(userDto.getRole());
        UserDtoConverter.updateFromDto(userDto, user, role, outlet);
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
        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        Credential credential = credentialService.findByUsername(username);
        User authorizedUser = userService.findByCredential(credential);
        return authorizedUser;
    }
}
