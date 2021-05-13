package com.maximalus.security.jwt;

import com.maximalus.model.Credential;
import com.maximalus.service.CredentialService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
@AllArgsConstructor
public class JwtUserDetailsService implements UserDetailsService {
    private final CredentialService credentialService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Credential credential = credentialService.findByUsername(username);

        if(Objects.isNull(credential)){
            throw new UsernameNotFoundException(String.format("User %s is not found", username));
        }

        return JwtUserFactory.create(credential);
    }
}
