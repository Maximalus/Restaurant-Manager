package com.maximalus.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String outlet;
    private String role;
    private String password;
}
