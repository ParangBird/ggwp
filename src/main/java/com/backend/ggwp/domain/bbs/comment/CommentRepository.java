package com.backend.ggwp.domain.bbs.comment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findAllByPostId(Long postId);

    void deleteById(Long id);

    Optional<Comment> findById(Long id);
}
