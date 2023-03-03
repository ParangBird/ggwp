package com.backend.ggwp.email;

import com.backend.ggwp.domain.user.GgwpUser;
import com.backend.ggwp.domain.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmailControllerTest {
    @Autowired
    MockMvc mock;
    @MockBean
    EmailServiceImpl emailService;
    @MockBean
    UserService userService;

    @Test
    void emailSendPageTest() throws Exception {
        String url = "/bbs/email/send";
        mock.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("emailAuthDTO"));
    }

    @Test
    void emailSendTest() throws Exception {
        String url = "/bbs/email/send";
        given(userService.findByEmail("donchipong@naver.com")).willReturn(
                java.util.Optional.of(new GgwpUser("donchipong", "1111", "donchipong@naver.com"))
        );

        mock.perform(post(url).param("email", "donchipong@naver.com"))
                .andExpect(status().is3xxRedirection());
    }
}