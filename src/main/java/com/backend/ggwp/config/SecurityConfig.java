package com.backend.ggwp.config;

import com.backend.ggwp.domain.bbs.user.auth.PrincipalDetails;
import com.backend.ggwp.domain.bbs.user.oauth.PrincipalOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import java.io.IOException;
import java.io.PrintWriter;

@RequiredArgsConstructor
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final PrincipalOAuth2UserService principalOAuth2UserService;

    @Bean
    public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        // csrf 및 formLogin, logout 설정
        http.csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .formLogin()
                .loginPage("/bbs/loginRedirect")
                .loginProcessingUrl("/bbs/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .successHandler(loginSuccessHandler())
                .failureHandler(loginFailureHandler())
                .and()
                .logout().logoutUrl("/bbs/logout")
                .addLogoutHandler(logoutHandler());

        // 권한 설정
        http.authorizeRequests()
                .antMatchers("/bbs/modify/**", "/bbs/write/**").hasAnyRole("AUTHED_USER", "OAUTH2_USER")
                .anyRequest().permitAll();


        // oauth2 설정
        http.oauth2Login()
                .successHandler(loginSuccessHandler())
                .userInfoEndpoint()
                .userService(principalOAuth2UserService);

        return http.build();
    }

    private LogoutHandler logoutHandler() {
        return (req, res, auth) -> {
            if (req.getSession() != null) req.getSession().invalidate();
            try {
                res.sendRedirect("/bbs");
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    private AuthenticationFailureHandler loginFailureHandler() {
        return (req, res, auth) -> {
            try {
                res.setContentType("text/html; charset=utf-8");
                PrintWriter out = res.getWriter();
                out.print("<script>alert('회원정보를 확인해 주세요!'); location.href='/bbs';</script>");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    private AuthenticationSuccessHandler loginSuccessHandler() {
        return (req, res, auth) -> {
            PrincipalDetails details = (PrincipalDetails) auth.getPrincipal();
            req.getSession().setAttribute("user", details);
            res.sendRedirect("/bbs");
        };
    }
}
