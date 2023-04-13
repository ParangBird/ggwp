package com.backend.ggwp.utils;

import com.backend.ggwp.domain.bbs.post.Post;
import com.backend.ggwp.domain.bbs.post.PostDto;
import com.backend.ggwp.domain.bbs.post.PostEnum;
import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDto;
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
        GgwpUserDto userDTO = GgwpUserDto.builder().build();
        PostDto postDTO = PostDto.builder()
                .user(userDTO)
                .content("내용")
                .title("제목")
                .postTag(PostEnum.ADC)
                .build();
        Post map = modelMapper.map(postDTO, Post.class);
        assertThat(map.getContent()).isEqualTo("내용");
    }
}
