package com.backend.ggwp.config;

import com.backend.ggwp.domain.bbs.user.auth.PrincipalDetails;
import com.backend.ggwp.domain.bbs.user.oauth.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
                .formLogin()
                .loginPage("/bbs/loginRedirect")
                .loginProcessingUrl("/bbs/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(new AuthenticationSuccessHandler() {
                    @Override
                    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
                        PrincipalDetails details = (PrincipalDetails) authentication.getPrincipal();
                        request.getSession().setAttribute("user", details);
                        response.sendRedirect("/bbs");
                    }
                })
                .and()
                .authorizeRequests()
                .antMatchers("/bbs/modify/**", "/bbs/write/**").authenticated()
                .anyRequest().permitAll()
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
