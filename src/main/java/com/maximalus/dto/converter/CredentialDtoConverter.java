package com.maximalus.dto.converter;

import com.maximalus.dto.CredentialDto;
import com.maximalus.model.Credential;

public class CredentialDtoConverter {
    public static CredentialDto toDto(Credential credential){
        CredentialDto credentialDto = new CredentialDto();
        credentialDto.setId(credential.getId());
        credentialDto.setUsername(credential.getUsername());
        credentialDto.setRoleName(credential.getRole().getName());
        credentialDto.setCreationDate(credential.getCreationDate());
        credentialDto.setChangingDate(credential.getChangingDate());
        return credentialDto;
    }

    public static Credential fromDto(CredentialDto credentialDto){
        Credential credential = new Credential();
        credential.setUsername(credentialDto.getUsername());
        credential.setPassword(credentialDto.getPassword());
        return credential;
    }
}
