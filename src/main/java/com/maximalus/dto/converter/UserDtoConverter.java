package com.maximalus.dto.converter;

import com.maximalus.dto.UserDto;
import com.maximalus.model.User;

public class UserDtoConverter {
    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        userDto.setOutlet(user.getOutlet().getName());
        userDto.setRole(user.getRole().getName());
        System.out.println(userDto.toString());
        return userDto;
    }
}
