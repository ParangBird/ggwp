package com.backend.ggwp.utils;

import com.backend.ggwp.domain.bbs.user.user.UserService;
import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
public class TestContainerTest {
    @Container
    static MySQLContainer mySQLContainer = new MySQLContainer();
    @Autowired
    private UserService userService;

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

}
