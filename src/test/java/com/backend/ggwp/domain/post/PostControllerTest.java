package com.backend.ggwp.domain.post;

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
class PostControllerTest {
    @Autowired
    MockMvc mvc;

    @Test
    void writeGetTest() throws Exception {
        String url = "/bbs/write";
        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"));
    }

}