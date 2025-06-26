package com.template.productservice.entity;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private long id;
    private String uuid;
    private String login;
    private String email;
    private String password;
    private Role role;
}
