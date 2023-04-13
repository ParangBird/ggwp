package com.backend.ggwp.domain.bbs.post;


import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDto;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
@ToString
public class PostDto {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private GgwpUserDto user;
    @NotNull
    private PostEnum postTag;
}
