package com.maximalus.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CredentialDto {
    private Long id;
    private String username;
    private String password;
    private String roleName;
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
    private boolean isDeleted;
}
