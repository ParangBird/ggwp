package com.backend.ggwp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableCaching
@EnableJpaAuditing
@SpringBootApplication
public class GgwpApplication {

    public static void main(String[] args) {
        SpringApplication.run(GgwpApplication.class, args);
    }

}
