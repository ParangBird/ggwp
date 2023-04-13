package com.backend.ggwp.domain.bbs.post;

import com.backend.ggwp.domain.bbs.user.auth.PrincipalDetails;
import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDto;
import com.backend.ggwp.domain.bbs.user.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {

    private final HttpSession httpSession;
    private final PostService postService;
    private final UserService userService;
    private final ModelMapper modelMapper;

    @GetMapping("/bbs/write")
    public String write(Model model) {
        PrincipalDetails details = (PrincipalDetails) httpSession.getAttribute("user");
        GgwpUserDto user = details.getGgwpUserDto();
        PostDto post = PostDto.builder()
                .user(user)
                .build();
        model.addAttribute("post", post);
        return "bbs/write";
    }

    @PostMapping("/bbs/write")
    public String writePost(@Validated @ModelAttribute("post") PostDto postDTO,
                            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            log.info("retry to write");
            return "bbs/write";
        }
        log.info("Write Post : title {} , author {}, content {}, postTag {} ", postDTO.getTitle(), postDTO.getUser().getName(), postDTO.getContent(), postDTO.getPostTag());
        log.info("Writer email : {}", postDTO.getUser().getEmail());

        postService.save(postDTO);
        return "redirect:http://localhost:8080/bbs";
    }

    @GetMapping("/bbs/read/{postId}")
    public String readPost(@PathVariable String postId, Model model) throws Exception {
        PostDto post = postService.findPostById(Long.parseLong(postId));
        model.addAttribute("post", post);
        return "bbs/read";
    }

    @GetMapping("/bbs/modify/{postId}")
    public String showModifyPost(@PathVariable String postId, Model model, HttpServletResponse response) {
        PostDto postDTO = postService.findPostById(Long.parseLong(postId));
        validAuthorCheck(httpSession, postDTO, response);
        model.addAttribute("post", postDTO);
        return "bbs/modify";
    }

    @PostMapping("/bbs/modify/{postId}")
    public String modifyPost(@Validated @ModelAttribute("post") PostDto updateDTO,
                             BindingResult bindingResult, @PathVariable String postId,
                             HttpServletResponse response) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            log.info("retry to modify");
            return "bbs/modify";
        }
        PostDto postDTO = postService.findPostById(Long.parseLong(postId));
        validAuthorCheck(httpSession, postDTO, response);
        log.info("Modify Post : title {} , author {}, content {} ", updateDTO.getTitle(), updateDTO.getUser().getName(), updateDTO.getContent());
        postService.update(Long.parseLong(postId), updateDTO);
        return "redirect:/bbs";
    }

    @PostMapping("/bbs/delete/{postId}")
    public String deletePost(@PathVariable String postId, HttpServletResponse response) {
        PostDto postDTO = postService.findPostById(Long.parseLong(postId));
        validAuthorCheck(httpSession, postDTO, response);
        postService.deleteById(postDTO.getId());
        return "redirect:/bbs";
    }

    private void validAuthorCheck(HttpSession httpSession, PostDto post, HttpServletResponse response) {
        GgwpUserDto user = (GgwpUserDto) httpSession.getAttribute("ggwpUser");
        if (user == null || !user.getName().equals(post.getUser().getName())) {
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('권한이 없습니다!'); location.href='/bbs';</script>");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
