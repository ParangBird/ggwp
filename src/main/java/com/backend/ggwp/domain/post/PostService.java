package com.backend.ggwp.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public void save(Post post){
        postRepository.save(post);
    }

    public Optional<Post> findPostById(Long id) { return postRepository.findById(id);}

    public List<Post> findAll(){ return postRepository.findAll(); }

    public List<Post> findAllByTag(PostEnum tag){ return postRepository.findAllByPostTag(tag); }

    public void update(Long id) { postRepository.save(postRepository.getById(id)); }

    public void deleteById(Long id) { postRepository.deleteById(id);}

}
