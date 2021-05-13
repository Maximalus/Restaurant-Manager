package com.maximalus.controler;

import com.maximalus.dto.AuthenticationResponseDto;
import com.maximalus.dto.CredentialDto;
import com.maximalus.exception.JwtAuthenticationException;
import com.maximalus.model.Credential;
import com.maximalus.model.Role;
import com.maximalus.security.jwt.JwtTokenProvider;
import com.maximalus.service.CredentialService;
import com.maximalus.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/auth")
@AllArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final CredentialService credentialService;
    private final RoleService roleService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody CredentialDto credentialDto){
        try{
            String username = credentialDto.getUsername();
            String password = credentialDto.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            Credential credential = credentialService.findByUsername(username);
            Role role = credential.getRole();
            String token = jwtTokenProvider.createToken(username, role);
            AuthenticationResponseDto responseDto = new AuthenticationResponseDto(username, token);
            return ResponseEntity.ok(responseDto);
        }catch (JwtAuthenticationException exception){
            throw new BadCredentialsException("Invalid username or password");
        }
    }
}
