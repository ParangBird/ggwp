package com.backend.ggwp.domain.bbs.comment;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentService {
    private final CommentRepository commentRepository;

    public List<Comment> findAllByPostId(Long postId) {
        List<Comment> allByPostId = commentRepository.findAllByPostId(postId);
        return allByPostId;
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteById(Long id) {
        commentRepository.deleteById(id);
    }

    public Comment findById(Long id) {
        return commentRepository.findById(id).get();
    }
}
