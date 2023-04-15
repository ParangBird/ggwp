package com.backend.ggwp.domain.bbs.post;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureMockMvc
public class PostServiceTestWithMock {

    @MockBean
    private PostService postService;

    @Test
    void save_findById_test() {
        // given
        String title = "title";
        String content = "content";
        Long postId = 1L;
        PostDto postDto = PostDto.builder().title(title).content(content).build();
        when(postService.save(postDto)).thenReturn(postId);
        when(postService.findPostById(postId)).thenReturn(postDto);
        // when
        Long newPostId = postService.save(postDto);
        PostDto newPost = postService.findPostById(postId);
        // then
        assertThat(postId).isEqualTo(newPostId);
        assertThat(newPost.getTitle()).isEqualTo(postDto.getTitle());
        assertThat(newPost.getContent()).isEqualTo(postDto.getContent());
        verify(postService, times(1)).save(postDto);
        verify(postService, times(1)).findPostById(postId);
    }

    @Test
    void update_test() {
        // given
        String title = "title";
        String content = "content";
        PostDto postDto = PostDto.builder().title(title).content(content).build();
        when(postService.update(1L, postDto)).thenReturn(postDto);
        // when
        PostDto update = postService.update(1L, postDto);
        // then
        assertThat(update.getTitle()).isEqualTo(title);
        assertThat(update.getContent()).isEqualTo(content);
        verify(postService, times(1)).update(1L, postDto);
    }

    @Test
    void findAll_findAllByTag_count_test() {
        // given
        List<PostDto> build = List.of(
                PostDto.builder().postTag(PostEnum.ADC).build(),
                PostDto.builder().postTag(PostEnum.ADC).build(),
                PostDto.builder().postTag(PostEnum.TOP).build()
        );
        when(postService.findAll()).thenReturn(build);
        when(postService.findAllByTag(PostEnum.ADC)).thenReturn(build.subList(0, 2));
        when(postService.count()).thenReturn(3L);
        // when
        List<PostDto> all = postService.findAll();
        List<PostDto> allByTag = postService.findAllByTag(PostEnum.ADC);
        Long count = postService.count();
        // then
        assertThat(all).hasSize(3);
        assertThat(allByTag).hasSize(2);
        assertThat(count).isEqualTo(3);
        verify(postService, times(1)).findAll();
        verify(postService, times(1)).findAllByTag(PostEnum.ADC);
    }
}
