package com.backend.ggwp.config;

import com.backend.ggwp.auth.CustomOAuth2UserService;
import com.backend.ggwp.domain.bbs.user.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import java.io.IOException;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("**"/*, "/bbs", "/bbs/login", "/", "/bbs/top",
                        "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile"*/).permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout().logoutUrl("/bbs/logout").addLogoutHandler((req, res, auth) -> {
                    if (req.getSession() != null) req.getSession().invalidate();
                    try {
                        res.sendRedirect("/bbs");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
                .and()
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
        return http.build();
    }
}
