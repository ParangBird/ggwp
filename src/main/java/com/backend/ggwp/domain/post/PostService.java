package com.backend.ggwp.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void save(Post post){
        postRepository.save(post);
    }

}
