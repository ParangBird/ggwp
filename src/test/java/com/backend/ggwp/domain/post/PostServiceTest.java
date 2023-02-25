package com.backend.ggwp.domain.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {
    @Autowired
    PostService postService;

    String title = "title";
    String author = "author";
    String content = "content";
    String authorEmail = "email@naver.com";
    PostEnum tag = PostEnum.ADC;

    String updateTitle = "u_title";
    String updateContent = "u_content";
    PostEnum updatedTag = PostEnum.JUG;


    PostDTO testDTO(String title, String author, String content, String authorEmail, PostEnum tag) {
        return PostDTO.builder()
                .title(title)
                .author(author)
                .content(content)
                .authorEmail(authorEmail)
                .postTag(tag)
                .build();
    }

    @Test
    void saveTest() {

        Long saveId = postService.save(testDTO(title, author, content, authorEmail, tag));
        Post post = postService.findPostById(saveId).orElseThrow();

        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getAuthor()).isEqualTo(author);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getAuthorEmail()).isEqualTo(authorEmail);
        assertThat(post.getPostTag()).isEqualTo(tag);

        postService.deleteById(saveId);

    }

    @Test
    void updateTest() {
        PostDTO postDTO = testDTO(title, content, author, authorEmail, tag);
        Long saveId = postService.save(postDTO);
        Post post = postService.findPostById(saveId).orElseThrow();

        PostDTO updateDTO =
                PostDTO.builder()
                        .title(updateTitle)
                        .content(updateContent)
                        .postTag(updatedTag)
                        .build();

        postService.update(saveId, updateDTO);

        Post updatedPost = postService.findPostById(saveId).orElseThrow();

        assertThat(updatedPost.getTitle()).isEqualTo(updateTitle);
        assertThat(updatedPost.getContent()).isEqualTo(updateContent);
        assertThat(updatedPost.getPostTag()).isEqualTo(updatedTag);
    }
}