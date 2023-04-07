package com.backend.ggwp.domain.bbs.user;

import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDTO;
import com.backend.ggwp.domain.bbs.user.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import javax.servlet.http.HttpSession;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {
    @Autowired
    MockMvc mock;
    @Autowired
    UserService userService;

    @Test
    void loginTest() throws Exception {
        String url = "/bbs/login";
        Long save = userService.registerUser(GgwpUserDTO
                .builder()
                .email("testuser@naver.com")
                .password("123456")
                .build());
        HttpSession session =
                mock.perform(
                        post(url)
                                .param("email", "testuser@naver.com")
                                .param("password", "123456")
                ).andReturn().getRequest().getSession();
        assertThat(session.getAttribute("ggwpUser")).isNotNull();
        userService.deleteById(save);
    }

    @Test
    void registerGetTest() throws Exception {
        String url = "/bbs/register";
        mock.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("registerDto"));
    }

    @Test
    void registerPostTest() throws Exception {
        String url = "/bbs/register";
        mock.perform(
                post(url)
                        .param("email", "test@naver.com")
                        .param("userName", "test")
                        .param("password", "123456")
                        .param("passwordCheck", "123456")
        );
    }

    @Test
    void resetPasswordGetTest() throws Exception {
        String url = "/bbs/reset-password";
        mock.perform(
                        get(url)
                )
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("resetPasswordDto"));

    }
}