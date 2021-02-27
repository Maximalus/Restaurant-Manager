package com.maximalus.dto.converter;

import com.maximalus.dto.UserDto;
import com.maximalus.model.User;

public class UserDtoConverter {
    public static UserDto toDto(User user){
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setOutlet(user.getOutlet().getName());
        return userDto;
    }

    public static User fromDto(UserDto userDto){
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        return user;
    }
}
