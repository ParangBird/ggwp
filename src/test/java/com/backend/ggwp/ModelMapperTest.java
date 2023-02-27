package com.backend.ggwp;

import com.backend.ggwp.domain.post.Post;
import com.backend.ggwp.domain.post.PostDTO;
import com.backend.ggwp.domain.post.PostEnum;
import com.backend.ggwp.domain.user.dto.GgwpUserDTO;
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
        GgwpUserDTO userDTO = GgwpUserDTO.builder().build();
        PostDTO postDTO = PostDTO.builder()
                .userDTO(userDTO)
                .content("내용")
                .title("제목")
                .postTag(PostEnum.ADC)
                .build();
        Post map = modelMapper.map(postDTO, Post.class);
        assertThat(map.getContent()).isEqualTo("내용");
    }
}