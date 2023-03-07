package com.backend.ggwp.domain.game.summoner;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

class SummonerInfoServiceTest {

    @Test
    void dateTest() {
        LocalDateTime now = LocalDateTime.of(2016, 3, 3, 5, 5);
        LocalDateTime modifiedDate = LocalDateTime.of(2016, 3, 2, 3, 3);
        assertThat(now.isAfter(modifiedDate.plusDays(1))).isTrue();
    }
}