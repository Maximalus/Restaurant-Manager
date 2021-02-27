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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private RoleServiceImpl roleService;
    @Autowired
    private OutletServiceImpl outletService;
    @Autowired
    private CredentialServiceImpl credentialService;

    @GetMapping("/admin/admin")
    public String getAdminPage(){
        return "admin/admin";
    }

    @GetMapping("/admin/createUser")
    public String getCreateUserPage(Model model){
        model.addAttribute("userDto", new UserDto());
        model.addAttribute("outlets", getListOfOutletNames());
        model.addAttribute("roles", getListOfRoleNames());
        return "admin/manage/user/createUser";
    }

    @PostMapping("/admin/createUser")
    public String saveUserAndCredential(@ModelAttribute("userDto") UserDto userDto){
        Credential credential = CredentialDtoConverter.fromDto(userDto);
        Role role = roleService.findByName(userDto.getRole());
        credential.setRole(role);
        credentialService.save(credential);

        User user = UserDtoConverter.fromDto(userDto);
        Outlet outlet = outletService.findByName(userDto.getOutlet());
        user.setOutlet(outlet);
        user.setCredential(credential);
        userService.save(user);

        return "admin/manage/user/allUsers";
    }

    @GetMapping("/admin/allUsers")
    public String getManageUsersPage(Model model){
        List<UserDto> userDtoList =
                userService.findAll()
                        .stream()
                        .filter(user -> !user.equals(getAuthenticatedProfile()))
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
        model.addAttribute("roles", getListOfRoleNames());
        model.addAttribute("outlets", getListOfOutletNames());
        return "admin/manage/user/editUser";
    }

    @PostMapping(value = "/admin/editUser")
    public String postProfile(@RequestParam String id,
                                        @RequestParam String firstName,
                                        @RequestParam String lastName,
                                        @RequestParam String outlet){
        User user = userService.findById(Long.parseLong(id));
        user.setFirstName(firstName);
        user.setLastName(lastName);
        Outlet foundOutlet = outletService.findByName(outlet);
        user.setOutlet(foundOutlet);
        userService.update(user);
        return "admin/admin";
    }

    @GetMapping(value = "/admin/deleteUser")
    public String deleteProfile(@RequestParam("id") String id){
        Long userId = Long.parseLong(id);
        userService.deleteById(userId);
        return "admin/manage/user/allUsers";
    }

    private User getAuthenticatedProfile(){
        org.springframework.security.core.userdetails.User user =
                (org.springframework.security.core.userdetails.User)
                        SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = user.getUsername();
        Credential credential = credentialService.findByUsername(username);
        User authorizedUser = userService.findByCredential(credential);
        return authorizedUser;
    }

    private List<String> getListOfRoleNames(){
        return roleService.findAll()
                .stream().map(Role::getName).collect(Collectors.toList());
    }

    private List<String> getListOfOutletNames(){
        return outletService.findAll()
                .stream().map(Outlet::getName).collect(Collectors.toList());
    }
}
