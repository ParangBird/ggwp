package com.backend.ggwp.domain.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {
    @Autowired
    PostService postService;

    @Test
    void saveTest() {
        String author = "author";
        String content = "content";
        String title = "title";
        String authorEmail = "email";
        PostEnum postEnum = PostEnum.ADC;

        PostDTO postDTO = PostDTO.builder()
                .author(author)
                .content(content)
                .title(title)
                .authorEmail(authorEmail)
                .postTag(postEnum)
                .build();

        Long saveId = postService.save(postDTO);
        Post post = postService.findPostById(saveId).orElseThrow();

        assertThat(post.getAuthor()).isEqualTo(author);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getPostTag()).isEqualTo(postEnum);
        assertThat(post.getAuthorEmail()).isEqualTo(authorEmail);

        postService.deleteById(saveId);

    }
}