package com.backend.ggwp;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class PasswordEncoderTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("패스워드 암호화 테스트")
    void passwordEncode() {
        String raw = "1234";
        String encoded = passwordEncoder.encode(raw);
        assertThat(raw).isNotEqualTo(encoded);
        assertThat(passwordEncoder.matches(raw, passwordEncoder.encode(raw))).isEqualTo(true);

    }
}
