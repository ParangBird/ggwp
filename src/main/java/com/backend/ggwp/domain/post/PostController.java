package com.backend.ggwp.domain.post;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;

@Slf4j
@Controller
@RequiredArgsConstructor
public class PostController {

    private final HttpSession httpSession;
    private final PostService postService;

/*
    @GetMapping("/bbs/write")
    public String write(Model model) {
        OauthUser user = (OauthUser) httpSession.getAttribute("user");
        PostDTO post = PostDTO.builder().author(user.getName()).build();
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
        log.info("Write Post : title {} , author {}, content {}, postTag {} ", postDTO.getTitle(), postDTO.getAuthor(), postDTO.getContent(), post.getPostTag());
        log.info("Writer email : {}", postDTO.getAuthorEmail());
        postService.save(postDTO);
        return "redirect:http://localhost:8080/bbs";
    }

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

    @GetMapping("/bbs/read/{postId}")
    public String readPost(@PathVariable String postId, HttpServletResponse response, Model model) {
        Post post = validPostCheck(postId, response);
        model.addAttribute("post", post);
        return "bbs/read";
    }

    @GetMapping("/bbs/modify/{postId}")
    public String showModifyPost(@PathVariable String postId, HttpServletRequest request, HttpServletResponse response, Model model) {
        Post post = validPostCheck(postId, response);
        HttpSession session = request.getSession();
        OauthUser user = (OauthUser) session.getAttribute("user");
        validAuthorCheck(post, response, user);
        model.addAttribute("post", post);
        return "bbs/modify";
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
