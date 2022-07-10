package com.ezms.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.UUID;

@AllArgsConstructor
@Getter
public class UserDTO {
    private UUID userId;
    private String username;
    private String email;
}
