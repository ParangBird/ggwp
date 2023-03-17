package com.backend.ggwp.domain.game.summoner;

import com.backend.ggwp.domain.game.summoner.summonerinfo.SummonerInfoRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SummonerInfoServiceTest {

    @Autowired
    SummonerInfoRepository summonerInfoRepository;

    @Test
    @Disabled
    void dateTest() {
        LocalDateTime now = LocalDateTime.of(2016, 3, 3, 5, 5);
        LocalDateTime modifiedDate = LocalDateTime.of(2016, 3, 2, 3, 3);
        assertThat(now.isAfter(modifiedDate.plusDays(1))).isTrue();
    }

    @Test
    @Disabled
    void findByNameTest() {
        assertThat(summonerInfoRepository.findByName("돈까스치즈퐁당")).isNotEmpty();
    }
}