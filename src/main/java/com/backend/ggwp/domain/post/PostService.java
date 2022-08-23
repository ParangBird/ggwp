package com.backend.ggwp.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void save(Post post){
        postRepository.save(post);
    }

    public List<Post> findAll(){ return postRepository.findAll(); }

}
