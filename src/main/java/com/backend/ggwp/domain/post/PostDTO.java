package com.backend.ggwp.domain.post;


import com.backend.ggwp.domain.user.dto.GgwpUserDTO;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@AllArgsConstructor
@Setter
@NoArgsConstructor
@Getter
@ToString
public class PostDTO {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String content;
    private GgwpUserDTO user;
    @NotNull
    private PostEnum postTag;
}
