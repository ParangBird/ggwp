package com.backend.ggwp.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class GgwpUserDTO {
    private Long id;
    private String name;
    private String password;
    private String email;
    private boolean emailAuth;
}
