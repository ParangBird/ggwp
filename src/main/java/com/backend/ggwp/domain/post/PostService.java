package com.backend.ggwp.domain.post;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Long save(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        postRepository.save(post);
        return post.getId();
    }

    public Optional<Post> findPostById(Long id) {
        return postRepository.findById(id);
    }

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public List<Post> findAllByTag(PostEnum tag) {
        return postRepository.findAllByPostTag(tag);
    }

    public void update(Long id, PostDTO updatePostDTO) {
        Post updatePost = findPostById(id).get();
        updatePost.update(updatePostDTO);
        postRepository.save(updatePost);
    }

    public void deleteById(Long id) {
        postRepository.deleteById(id);
    }

    public void clear() {
        postRepository.deleteAll();
    }

    public Long count() {
        return postRepository.count();
    }

}
