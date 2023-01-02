package com.backend.ggwp.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/bbs/comment/test")
    public void commentTest(@RequestParam("content") String content, @RequestParam("author") String author) {
        Comment comment = Comment.builder()
                .id(0L)
                .content("댓글")
                .postId(123L)
                .postAuthor("작성자")
                .build();
        commentService.save(comment);
    }
}
