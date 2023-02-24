package com.backend.ggwp.domain.post;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PostDTO {
    private String title;
    private String author;
    private String content;
    private String authorEmail;
    private PostEnum postTag;
}
