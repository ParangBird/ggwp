package com.backend.ggwp.domain.user;

import com.backend.ggwp.domain.user.dto.GgwpUserDTO;
import com.backend.ggwp.domain.user.dto.LoginDto;
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
        GgwpUser savedUser = userService.findById(saveId).orElseThrow();
        assertThat(savedUser.getName()).isEqualTo(name);
        assertThat(savedUser.getEmail()).isEqualTo(email);
        //userService.deleteById(saveId);
    }

    @Test
    void loginTest(){
        LoginDto loginDto = new LoginDto("email", "1111");
        GgwpUser login = userService.login(loginDto);
        assertThat(login).isNotNull();
    }
}