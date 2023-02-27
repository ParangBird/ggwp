package com.backend.ggwp.domain.user.dto;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GgwpUserDTO {
    private String name;
    private String password;
    private String email;
    private boolean emailAuth;
}
