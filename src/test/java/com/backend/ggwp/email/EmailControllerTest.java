package com.backend.ggwp.email;

import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDto;
import com.backend.ggwp.domain.bbs.user.user.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.mapping.JpaMetamodelMappingContext;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(EmailController.class)
@MockBean(JpaMetamodelMappingContext.class)
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
        mock.perform(get(url).secure(true))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("emailAuthDTO"));
    }

    @Test
    void emailSendTest() throws Exception {
        String url = "/bbs/email/send";
        given(userService.findByEmail("donchipong@naver.com")).willReturn(
                new GgwpUserDto("donchipong", "1111", "donchipong@naver.com", false)
        );
        mock.perform(post(url).param("email", "donchipong@naver.com"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void emailAuthPageTest() throws Exception {
        String url = "/bbs/email/auth";
        mock.perform(get(url))
                .andExpect(status().isOk());
    }
}