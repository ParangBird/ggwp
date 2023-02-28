package com.backend.ggwp.domain.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class PostControllerTest {
    @Autowired
    MockMvc mvc;
    @MockBean
    PostService postService;

    @Test
    void writeGetTest() throws Exception {
        String url = "/bbs/write";
        mvc.perform(get(url))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"));
    }

    @Test
    void writePostTest() throws Exception {
        String url = "/bbs/write";
        mvc.perform(post(url).param("title", "내용")
                        .param("content", "콘텐츠")
                        .param("postTag", PostEnum.ADC.tag())
                        .param("userDTO.name", "사용자")
                        .param("userDTO.email", "이메일"))
                .andExpect(status().is3xxRedirection());
    }

    @Test
    void noSuchPostTest() throws Exception {
        String url = "/bbs/write/12345";
        mvc.perform(get(url))
                .andExpect(status().isNotFound());
    }

}