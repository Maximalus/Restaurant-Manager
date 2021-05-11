package com.maximalus.dto.converter;

import com.maximalus.dto.CredentialDto;
import com.maximalus.model.Credential;

public class CredentialDtoConverter {
    public static CredentialDto toDto(Credential credential){
        CredentialDto credentialDto = new CredentialDto();
        credentialDto.setId(credential.getId());
        credentialDto.setUsername(credential.getUsername());
        credentialDto.setPassword(credential.getPassword());
        credentialDto.setRole(credential.getRole().getName());
        return credentialDto;
    }
}
