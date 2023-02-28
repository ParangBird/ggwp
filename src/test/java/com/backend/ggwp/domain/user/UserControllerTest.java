package com.backend.ggwp.domain.user;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
    @Mock
    UserService userService;

    @Test
    void loginTest() throws Exception {
        String url = "/bbs/login";
        HttpSession session = mock.perform(
                post(url)
                        .param("email", "test@naver.com")
                        .param("password", "123456")
        ).andReturn().getRequest().getSession();
        assertThat(session.getAttribute("ggwpUser")).isNotNull();
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
                                .param("email", "hello@naver.com")
                                .param("userName", "hello")
                                .param("password", "hellopwd")
                                .param("passwordCheck", "hellopwd")
                )
                .andExpect(status().is3xxRedirection());
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