package com.maximalus.dto.converter;

import com.maximalus.dto.UserDto;
import com.maximalus.model.Credential;

public class CredentialDtoConverter {
    public static Credential fromDto(UserDto userDto){
        Credential credential = new Credential();
        credential.setUsername(userDto.getEmail());
        credential.setPassword(userDto.getPassword());
        credential.setDeleted(false);
        return credential;
    }
}
