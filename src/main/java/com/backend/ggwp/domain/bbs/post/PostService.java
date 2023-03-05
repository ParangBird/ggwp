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
    public Long save(PostDTO postDTO) {
        Post post = modelMapper.map(postDTO, Post.class);
        postRepository.save(post);
        return post.getId();
    }

    @Transactional
    public void update(Long id, PostDTO updatePostDTO) {
        Post updatePost = postRepository.findById(id).orElseThrow();
        updatePost.update(updatePostDTO);
        postRepository.save(updatePost);
    }

    @Transactional(readOnly = true)
    public PostDTO findPostById(Long id) {
        Post post = postRepository.findById(id).orElseThrow(() -> new NoSuchPostFoundException("해당 게시글 없음"));
        PostDTO dto = modelMapper.map(post, PostDTO.class);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<PostDTO> findAll() {
        List<Post> all = postRepository.findAll();
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : all) {
            postDTOList.add(modelMapper.map(post, PostDTO.class));
        }
        return postDTOList;
    }

    @Transactional(readOnly = true)
    public List<PostDTO> findAllByTag(PostEnum tag) {
        List<Post> allByPostTag = postRepository.findAllByPostTag(tag);
        List<PostDTO> postDTOList = new ArrayList<>();
        for (Post post : allByPostTag) {
            postDTOList.add(modelMapper.map(post, PostDTO.class));
        }
        return postDTOList;
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
