package com.backend.ggwp.domain.user.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RegisterDto {
    @NotBlank(message = "이메일을 입력해주세요")
    private String email;
    @Pattern(regexp = "[a-zA-Z0-9]{4,12}", message = "닉네임은 영어와 숫자를 사용한 4-12자 입니다.")
    private String userName;
    @Pattern(regexp = "[a-zA-Z0-9]{6,12}", message = "비밀번호는 영어와 숫자를 사용한 6-12자 입니다.")
    private String password;
    @NotBlank(message = "비밀번호 확인을 입력해주세요")
    private String passwordCheck;
}
