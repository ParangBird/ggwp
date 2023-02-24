package com.backend.ggwp.domain.post;


import lombok.*;

import javax.validation.constraints.NotBlank;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class PostDTO {
    @NotBlank
    private String title;
    @NotBlank
    private String author;
    @NotBlank
    private String content;
    @NotBlank
    private String authorEmail;
    @NotBlank
    private PostEnum postTag;
}
