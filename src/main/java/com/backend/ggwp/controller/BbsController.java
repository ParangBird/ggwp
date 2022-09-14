package com.backend.ggwp.controller;

import com.backend.ggwp.ApiInfo;
import com.backend.ggwp.config.auth.dto.SessionUser;
import com.backend.ggwp.domain.entity.RotationInfo;
import com.backend.ggwp.domain.post.Post;
import com.backend.ggwp.domain.post.PostService;
import com.backend.ggwp.service.RestApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BbsController {

    private final HttpSession httpSession;
    private final ApiInfo API_INFO;
    private final RestApiService restApiService;
    private final PostService postService;

    @GetMapping("/bbs")
    public String index(Model model, @RequestParam(required = false) String postTag) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        RotationInfo rotationInfo = restApiService.getRotationInfo();
        List<Integer> freeChampionIds = rotationInfo.getFreeChampionIds();
        ArrayList<String> freeChampionNames = new ArrayList<>();

        for(int i=0;i<freeChampionIds.size();i++){
            freeChampionNames.add(HomeController.changeChampionIdToName(freeChampionIds.get(i)));
        }
        model.addAttribute("freeChampionNames1",freeChampionNames.subList(0,8));
        model.addAttribute("freeChampionNames2", freeChampionNames.subList(8,16));
        model.addAttribute("version", API_INFO.getVersion());
        if(postTag == null)
            model.addAttribute("posts", postService.findAll());
        else
            model.addAttribute("posts", postService.findAllByTag(postTag));
        return "bbs/index";
    }
    @GetMapping("/bbs/login")
    public String login(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "bbs/login";
    }

    @GetMapping("/bbs/write")
    public String write(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        Post post = new Post();
        if(user != null) {
            post.setAuthor(user.getName());
        }
        model.addAttribute("post", post);
        return "bbs/write";
    }

    @PostMapping("/bbs/write")
    public String writePost(@Validated @ModelAttribute("post") Post post,
                    BindingResult bindingResult){
        if(bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            log.info("retry to write");
            return "bbs/write";
        }
        log.info("Write Post : title {} , author {}, content {} ", post.getTitle(), post.getAuthor(), post.getContent());
        postService.save(post);
        return "redirect:http://localhost:8080/bbs";
    }

    private Post validPostCheck(String postId, HttpServletResponse response){
        Long id = Long.parseLong(postId);
        Optional<Post> post = postService.findPostById(id);
        if(post.isEmpty()){
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
    public String readPost(@PathVariable String postId, HttpServletResponse response, Model model){
        Post post = validPostCheck(postId, response);
        model.addAttribute("post", post);
        return "bbs/read";
    }

    @GetMapping("/bbs/modify/{postId}")
    public String showModifyPost(@PathVariable String postId, HttpServletResponse response, Model model){
        Post post = validPostCheck(postId, response);
        model.addAttribute("post", post);
        return "bbs/modify";
    }

    @PostMapping("/bbs/modify/{postId}")
    public String modifyPost(@Validated @ModelAttribute("post") Post post,
                             BindingResult bindingResult, @PathVariable String postId){
        if(bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            log.info("retry to modify");
            return "bbs/modify";
        }
        log.info("Modify Post : title {} , author {}, content {} ", post.getTitle(), post.getAuthor(), post.getContent());
        postService.update(post.getId());
        return "redirect:/bbs";
    }

    @PostMapping("/bbs/delete/{postId}")
    public String deletePost(@PathVariable String postId){
        Long id = Long.parseLong(postId);
        Optional<Post> post = postService.findPostById(id);
        if(post.isEmpty()){
            // error
        }
        postService.deleteById(id);
        return "redirect:/bbs";
    }

    @GetMapping("/logout")
    public String logout(){
        return "bbs/index";
    }

    @PostMapping(value = "/searchSummoner", produces = "text/html;charset=UTF-8")
    public String search(HttpServletRequest request, @RequestParam("summonerName")String summonerName) throws UnsupportedEncodingException {
        String encodedParam = URLEncoder.encode(summonerName, "UTF-8");
        return "redirect:http://localhost:3000/search/" + encodedParam;
    }

}
