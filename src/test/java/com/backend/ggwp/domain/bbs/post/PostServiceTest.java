package com.backend.ggwp.domain.bbs.post;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PostServiceTest {
    @Autowired
    PostService postService;

    String title = "title";
    String content = "content";
    PostEnum tag = PostEnum.ADC;

    String updateTitle = "u_title";
    String updateContent = "u_content";
    PostEnum updatedTag = PostEnum.JUG;


    PostDto testDTO(String title, String content, PostEnum tag) {
        return PostDto.builder()
                .title(title)
                .content(content)
                .postTag(tag)
                .build();
    }

    @Test
    void saveTest() {


        Long saveId = postService.save(testDTO(title, content, tag));
        PostDto post = postService.findPostById(saveId);

        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(content);
        assertThat(post.getPostTag()).isEqualTo(tag);

        postService.deleteById(saveId);

    }

    @Test
    void updateTest() {
        PostDto postDTO = testDTO(title, content, tag);
        Long saveId = postService.save(postDTO);

        PostDto updateDTO =
                PostDto.builder()
                        .title(updateTitle)
                        .content(updateContent)
                        .postTag(updatedTag)
                        .build();

        postService.update(saveId, updateDTO);

        PostDto updatedPost = postService.findPostById(saveId);

        assertThat(updatedPost.getTitle()).isEqualTo(updateTitle);
        assertThat(updatedPost.getContent()).isEqualTo(updateContent);
        assertThat(updatedPost.getPostTag()).isEqualTo(updatedTag);

        postService.deleteById(saveId);
    }
}