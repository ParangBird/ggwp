package com.backend.ggwp.domain.bbs.user.nickname;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RandomNicknameServiceTest {

    @Autowired
    private RandomNicknameService randomNicknameService;
    @Autowired
    private RandomNicknameRepository repository;

    @Test
    void nicknameGenerateTest() {
        String nickname = randomNicknameService.randomNickname(5);
        System.out.println("generated : " + nickname);
        Assertions.assertThat(nickname).isNotNull();
        repository.deleteByNickname(nickname);
    }
}