package com.maximalus.dto;

import lombok.Data;

import java.util.Set;


@Data
public class CredentialDto {
    private Long id;
    private String username;
    private String password;
    private String role;
    private Set<String> permissions;
}
