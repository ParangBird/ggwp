package com.backend.ggwp.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;
    @NotBlank(message = "닉네임을 입력해주세요")
    private String userName;
    @NotBlank(message = "비밀번호를 입력해주세요")
    private String password;
    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    private String passwordCheck;
}
