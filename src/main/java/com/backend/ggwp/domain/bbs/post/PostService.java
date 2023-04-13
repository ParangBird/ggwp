package com.backend.ggwp.domain.bbs.post;

import com.backend.ggwp.exception.NoSuchPostFoundException;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final ModelMapper modelMapper;

    @Transactional
    public Long save(PostDto postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        postRepository.save(post);
        return post.getId();
    }

    @Transactional
    public void update(Long id, PostDto updatePostDto) {
        Post updatePost = postRepository.findById(id).orElseThrow();
        updatePost.update(updatePostDto);
        postRepository.save(updatePost);
    }

    @Transactional(readOnly = true)
    public PostDto findPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NoSuchPostFoundException("해당 게시글 없음"));
        PostDto dto = modelMapper.map(post, PostDto.class);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<PostDto> findAll() {
        List<Post> all = postRepository.findAll();
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : all) {
            postDtoList.add(modelMapper.map(post, PostDto.class));
        }
        return postDtoList;
    }

    @Transactional(readOnly = true)
    public List<PostDto> findAllByTag(PostEnum tag) {
        List<Post> allByPostTag = postRepository.findAllByPostTag(tag);
        List<PostDto> postDtoList = new ArrayList<>();
        for (Post post : allByPostTag) {
            postDtoList.add(modelMapper.map(post, PostDto.class));
        }
        return postDtoList;
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
