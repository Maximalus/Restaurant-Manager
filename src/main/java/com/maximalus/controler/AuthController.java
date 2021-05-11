package com.maximalus.controler;

import com.maximalus.dto.CredentialDto;
import com.maximalus.dto.converter.CredentialDtoConverter;
import com.maximalus.model.Credential;
import com.maximalus.model.Permission;
import com.maximalus.service.CredentialService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {
    private final CredentialService service;

    @PostMapping(path = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody CredentialDto getAuthUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        Object principal = auth.getPrincipal();
        User user = (principal instanceof User) ? (User) principal : null;

        Credential credential = Objects.nonNull(user) ? this.service.findByUsername(user.getUsername()) : null;

        return getCredentialDto(credential);
    }

    private CredentialDto getCredentialDto(Credential credential){
        Set<String> permissionsSet =
                credential.getRole().getPermissions().stream()
                        .map(Permission::getName).collect(Collectors.toSet());

        CredentialDto credentialDto = CredentialDtoConverter.toDto(credential);
        credentialDto.setPermissions(permissionsSet);

        return credentialDto;
    }
}
