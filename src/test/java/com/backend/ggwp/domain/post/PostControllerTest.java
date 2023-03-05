package com.backend.ggwp.domain.post;

import com.backend.ggwp.domain.user.UserService;
import com.backend.ggwp.domain.user.dto.GgwpUserDTO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.MOCK)
@AutoConfigureMockMvc
class PostControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService userService;
    @MockBean
    private PostService postService;

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
                        .param("user.name", "사용자")
                        .param("user.email", "이메일"))
                .andExpect(status().is3xxRedirection());

    }

    @Test
    void noSuchPostTest() throws Exception {
        String url = "/bbs/write/12345";
        mvc.perform(get(url))
                .andExpect(status().isNotFound());
    }

    @Test
    void modifyGetTest() throws Exception {
        GgwpUserDTO ggwpUser = GgwpUserDTO.builder()
                .name("donchipong")
                .email("donchipong@naver.com")
                .password("12345")
                .build();
        given(postService.findPostById(1L)).willReturn(
                new PostDTO(1L, "333", "3333", ggwpUser, PostEnum.ADC)
        );
        String url = "/bbs/modify/1";
        GgwpUserDTO userDTO = GgwpUserDTO.builder().name("donchipong").build();
        mvc.perform(get(url).sessionAttr("ggwpUser", userDTO))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("post"));
    }

    @Test
    void modifyPostTest() throws Exception {
        GgwpUserDTO ggwpUser = GgwpUserDTO.builder()
                .name("donchipong")
                .email("donchipong@naver.com")
                .password("12345")
                .build();
        given(postService.findPostById(1L)).willReturn(
                new PostDTO(1L, "333", "3333", ggwpUser, PostEnum.ADC)
        );
        String url = "/bbs/modify/1";
        GgwpUserDTO userDTO = GgwpUserDTO.builder().name("donchipong").build();
        mvc.perform(post(url)
                        .sessionAttr("ggwpUser", userDTO)
                        .param("title", "444")
                        .param("content", "444")
                        .param("postTag", PostEnum.ADC.tag())
                        .param("user.name", "donchipong")
                        .param("user.email", "donchipong@naver.com"))
                .andExpect(status().is3xxRedirection());
    }


    @Test
    void deleteTest() throws Exception {
        GgwpUserDTO ggwpUser = GgwpUserDTO.builder()
                .name("donchipong")
                .email("donchipong@naver.com")
                .password("12345")
                .build();
        given(postService.findPostById(1L)).willReturn(
                new PostDTO(1L, "333", "3333", ggwpUser, PostEnum.ADC)
        );
        String url = "/bbs/delete/1";
        GgwpUserDTO userDTO = GgwpUserDTO.builder().name("donchipong").build();
        mvc.perform(post(url).sessionAttr("ggwpUser", userDTO))
                .andExpect(status().is3xxRedirection());
    }

}