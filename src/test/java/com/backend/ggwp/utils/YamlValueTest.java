package com.backend.ggwp.utils;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class YamlValueTest {
    @Value("${riot.api.key}")
    private String apiKey;

    @Test
    void getYamlValue() {
        Assertions.assertThat(apiKey).isNotNull();
    }
}
