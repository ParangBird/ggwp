package com.backend.ggwp.domain.bbs.user.nickname;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NicknameGenerateServiceTest {
    @Autowired
    private NicknameGenerateService nicknameGenerateService;

    @Test
    void nicknameGenerateTest() {
        String s = nicknameGenerateService.randomNickname(8);
        System.out.println("generated : " + s);
        Assertions.assertThat(s).isNotNull();
    }
}