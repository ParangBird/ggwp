package com.backend.ggwp.domain.bbs.post;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureMockMvc
public class PostServiceTestWithMock {

    @MockBean
    private PostService postService;

    @Test
    void saveAndFindByPostIdTest() {
        // given
        String title = "title";
        String content = "content";
        Long postId = 1L;
        PostDto postDto = PostDto.builder().title(title).content(content).build();
        Mockito.when(postService.save(postDto)).thenReturn(postId);
        Mockito.when(postService.findPostById(postId)).thenReturn(postDto);
        // when
        Long newPostId = postService.save(postDto);
        PostDto newPost = postService.findPostById(postId);
        // then
        assertThat(postId).isEqualTo(newPostId);
        assertThat(newPost.getTitle()).isEqualTo(postDto.getTitle());
        assertThat(newPost.getContent()).isEqualTo(postDto.getContent());
    }
}
