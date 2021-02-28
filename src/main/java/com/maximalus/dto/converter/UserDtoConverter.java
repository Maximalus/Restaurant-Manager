package com.maximalus.dto.converter;

import com.maximalus.dto.UserDto;
import com.maximalus.model.Outlet;
import com.maximalus.model.Role;
import com.maximalus.model.User;

import java.time.LocalDateTime;

public class UserDtoConverter {
    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setOutlet(user.getOutlet().getName());
        userDto.setRole(user.getCredential().getRole().getName());
        userDto.setEmail(user.getCredential().getUsername());
        userDto.setCreationDate(user.getCreationDate());
        userDto.setChangingDate(user.getChangingDate());
        return userDto;
    }

    public static User createFromDto(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setDeleted(false);
        return user;
    }

    public static void updateFromDto(UserDto userDto, User user, Role role, Outlet outlet){
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.getCredential().setRole(role);
        user.getCredential().setChangingDate(LocalDateTime.now());
        user.setOutlet(outlet);
    }
}
