package com.backend.ggwp;

import com.backend.ggwp.domain.post.Post;
import com.backend.ggwp.domain.post.PostDTO;
import com.backend.ggwp.domain.post.PostEnum;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class ModelMapperTest {
    @Autowired
    ModelMapper modelMapper;

    @Test
    void modelMapperTest() {
        PostDTO postDTO = PostDTO.builder()
                .author("작성자")
                .content("내용")
                .title("제목")
                .authorEmail("이메일")
                .postTag(PostEnum.ADC)
                .build();
        Post map = modelMapper.map(postDTO, Post.class);
        assertThat(map.getContent()).isEqualTo("내용");
    }
}
