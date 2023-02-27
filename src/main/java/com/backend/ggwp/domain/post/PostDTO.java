package com.backend.ggwp.domain.post;


import com.backend.ggwp.domain.user.dto.GgwpUserDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Getter
@ToString
public class PostDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    @Setter
    private GgwpUserDTO userDTO;
    @NotNull
    private PostEnum postTag;
}
