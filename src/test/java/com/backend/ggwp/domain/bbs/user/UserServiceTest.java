package com.backend.ggwp.domain.bbs.user;

import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDTO;
import com.backend.ggwp.domain.bbs.user.dto.LoginDto;
import com.backend.ggwp.domain.bbs.user.dto.RegisterDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserServiceTest {
    @Autowired
    UserService userService;

    @Test
    void saveTest() {
        String name = "유저이름";
        String email = "email";
        String password = "1111";
        boolean auth = false;

        GgwpUserDTO ggwpUserDTO = GgwpUserDTO.builder().name(name)
                .email(email)
                .password(password)
                .emailAuth(auth)
                .build();
        Long saveId = userService.save(ggwpUserDTO);
        GgwpUserDTO savedUser = userService.findById(saveId);
        assertThat(savedUser.getName()).isEqualTo(name);
        assertThat(savedUser.getEmail()).isEqualTo(email);
        userService.deleteById(saveId);
    }

    @Test
    void loginTest() {
        Long save = userService.registerUser(GgwpUserDTO
                .builder()
                .email("testuser@naver.com")
                .password("123456")
                .build());
        LoginDto loginDto = new LoginDto("testuser@naver.com", "123456");
        GgwpUserDTO userDTO = userService.login(loginDto);
        assertThat(userDTO).isNotNull();
        userService.deleteById(save);
    }

    @Test
    void registerTest() {
        String newUserEmail = "testuser@naver.com";
        RegisterDto registerDto = new RegisterDto(newUserEmail, "TESTUSER", "123456", "123456");
        Long id = userService.registerUser(registerDto);
        GgwpUserDTO ggwpUser = userService.findByEmail(newUserEmail);
        assertThat(ggwpUser).isNotNull();
        userService.deleteById(id);
    }
}