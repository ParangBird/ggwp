package com.backend.ggwp.domain.bbs.user.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class GgwpUserDTO {
    private String name;
    private String password;
    private String email;
    private boolean emailAuth;
    private String role;
    private String provider;
    private String providerId;

    public GgwpUserDTO(String name, String password, String email, boolean emailAuth) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.emailAuth = emailAuth;
    }
}
