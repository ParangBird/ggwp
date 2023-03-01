package com.backend.ggwp.domain.post;

import com.backend.ggwp.domain.exception.NoSuchPostFoundException;
import com.backend.ggwp.domain.user.UserService;
import com.backend.ggwp.domain.user.dto.GgwpUserDTO;
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
        //OauthUser user = (OauthUser) httpSession.getAttribute("user");
        GgwpUserDTO user = (GgwpUserDTO) httpSession.getAttribute("ggwpUser");
        PostDTO post = PostDTO.builder()
                .user(user)
                .build();
        model.addAttribute("post", post);
        return "bbs/write";
    }

    @PostMapping("/bbs/write")
    public String writePost(@Validated @ModelAttribute("post") PostDTO postDTO,
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
        Post post = postService.findPostById(Long.parseLong(postId))
                .orElseThrow(() -> new NoSuchPostFoundException("해당 게시글 없음"));
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
        model.addAttribute("post", postDTO);
        return "bbs/read";
    }

    @GetMapping("/bbs/modify/{postId}")
    public String showModifyPost(@PathVariable String postId, Model model, HttpServletResponse response) {
        Post post = postService.findPostById(Long.parseLong(postId))
                .orElseThrow(() -> new NoSuchPostFoundException("해당 게시글 없음"));
        validAuthorCheck(httpSession, post, response);
        PostDTO postDTO = modelMapper.map(post, PostDTO.class);
        model.addAttribute("post", postDTO);
        return "bbs/modify";
    }

    private void validAuthorCheck(HttpSession httpSession, Post post, HttpServletResponse response) {
        GgwpUserDTO user = (GgwpUserDTO) httpSession.getAttribute("ggwpUser");
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

    /*

    private void validAuthorCheck(PostDTO post, HttpServletResponse response, OauthUser user) {
        if (user == null || post.getAuthorEmail() == null || user.getEmail() == null || !post.getAuthorEmail().equals(user.getEmail())) {
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

    private Post validPostCheck(String postId, HttpServletResponse response) {
        Long id = Long.parseLong(postId);
        Optional<Post> post = postService.findPostById(id);
        if (post.isEmpty()) {
            log.info("사용자가 존재하지 않는 페이지에 접근");
            response.setContentType("text/html;charset=UTF-8");
            try {
                PrintWriter out = null;
                out = response.getWriter();
                out.println("<script>alert('해당 게시글이 존재하지 않습니다.'); location.href='/bbs';</script>");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return post.get();
    }


    @PostMapping("/bbs/modify/{postId}")
    public String modifyPost(@Validated @ModelAttribute("post") PostDTO postDTO,
                             BindingResult bindingResult, @PathVariable String postId,
                             HttpServletResponse response, HttpSession session) {
        OauthUser user = (OauthUser) session.getAttribute("user");
        validAuthorCheck(postDTO, response, user);
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            log.info("retry to modify");
            return "bbs/modify";
        }
        log.info("Modify Post : title {} , author {}, content {} ", postDTO.getTitle(), postDTO.getAuthor(), postDTO.getContent());
        postService.update(Long.parseLong(postId), postDTO);
        return "redirect:/bbs";
    }

    @PostMapping("/bbs/delete/{postId}")
    public String deletePost(@PathVariable String postId, HttpServletResponse response, HttpSession session) {
        Post post = validPostCheck(postId, response);
        OauthUser user = (OauthUser) session.getAttribute("user");
        validAuthorCheck(post, response, user);
        postService.deleteById(post.getId());
        return "redirect:/bbs";
    }
*/


}
