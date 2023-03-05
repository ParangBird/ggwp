package com.backend.ggwp.domain.bbs.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResetPasswordDto {
    @Email
    @NotBlank(message = "올바른 이메일을 입력해주세요")
    private String email;
}
