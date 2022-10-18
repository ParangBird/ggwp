package com.backend.ggwp.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    private String userName;
    private String password;
    private String passwordCheck;
    private String email;
}
