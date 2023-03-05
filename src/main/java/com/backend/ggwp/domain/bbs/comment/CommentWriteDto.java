package com.backend.ggwp.domain.bbs.comment;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentWriteDto {
    private String content;
    private Long postId;
    private String author;
}
