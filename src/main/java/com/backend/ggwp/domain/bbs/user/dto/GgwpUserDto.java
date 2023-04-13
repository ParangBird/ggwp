package com.backend.ggwp.domain.bbs.user.dto;

import com.backend.ggwp.domain.bbs.user.user.Role;
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
    private Role role;
    private String provider;
    private String providerId;
    private boolean emailAuth;

    public GgwpUserDto(String name, String password, String email, boolean emailAuth) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.emailAuth = emailAuth;
    }

    public boolean getEmailAuth() {
        return this.emailAuth;
    }

    public void authUser() {
        role = Role.ROLE_AUTHED_USER;
        emailAuth = true;
    }
}
