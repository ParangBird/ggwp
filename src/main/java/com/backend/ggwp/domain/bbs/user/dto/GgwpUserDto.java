package com.backend.ggwp.domain.bbs.user.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GgwpUserDto {
    private String name;
    private String password;
    private String email;
    private boolean emailAuth;
    private String role;
    private String provider;
    private String providerId;

    public GgwpUserDto(String name, String password, String email, boolean emailAuth) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.emailAuth = emailAuth;
    }

    public void emailAuthed() {
        role = "ROLE_AUTHED_USER";
        emailAuth = true;
    }
}
