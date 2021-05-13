package com.maximalus.security.jwt;

import com.maximalus.model.Credential;
import com.maximalus.model.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;
import java.util.stream.Collectors;

public final class JwtUserFactory {
    public JwtUserFactory() {
    }

    public static JwtUser create(Credential credential){
        return new JwtUser(credential.getId(),
                credential.getUsername(),
                credential.getPassword(),
                !credential.isDeleted(),
                credential.getChangingDate(),
                mapToGrantedAuthorities(credential.getRole()));
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(Role role){
        return role.getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getName())).collect(Collectors.toList());
    }
}
