package com.maximalus.dto;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String outlet;
    private String role;
    private String password;
    private LocalDateTime creationDate;
    private LocalDateTime changingDate;
}
