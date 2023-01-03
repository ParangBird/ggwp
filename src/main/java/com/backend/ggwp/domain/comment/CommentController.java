package com.backend.ggwp.domain.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Controller
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/bbs/comment/write/test")
    public String commentWriteTest(@ModelAttribute("commentWriteDto") CommentWriteDto commentWriteDto) {
        Comment comment = Comment.builder()
                .content(commentWriteDto.getContent())
                .postId(commentWriteDto.getPostId())
                .postAuthor(commentWriteDto.getAuthor())
                .build();
        commentService.save(comment);
        return "ok";
    }

    @PostMapping("/bbs/comment/delete/test")
    public String commentDeleteTest(@RequestParam("id") Long id) {
        commentService.deleteById(id);
        return "ok";
    }

    @PostMapping("/bbs/comment/modify/test")
    public String commentModifyTest(@RequestParam("id") Long id, @RequestParam("content") String newContent) {
        Comment comment = commentService.findById(id);
        comment = Comment.builder()
                .id(comment.getId())
                .content(newContent)
                .postAuthor(comment.getPostAuthor())
                .postId(comment.getPostId())
                .build();
        commentService.save(comment);
        return "ok";
    }
}
