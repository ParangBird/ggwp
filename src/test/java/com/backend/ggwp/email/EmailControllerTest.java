package com.backend.ggwp.email;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class EmailControllerTest {
    @Autowired
    MockMvc mock;

    @Test
    void emailSendPageGetTest() throws Exception {
        String url = "/bbs/email/send";
        mock.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("emailAuthDTO"));
    }
}