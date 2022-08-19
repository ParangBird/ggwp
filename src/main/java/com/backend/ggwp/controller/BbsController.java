package com.backend.ggwp.controller;

import com.backend.ggwp.ApiInfo;
import com.backend.ggwp.config.auth.dto.SessionUser;
import com.backend.ggwp.domain.entity.RotationInfo;
import com.backend.ggwp.domain.post.Post;
import com.backend.ggwp.domain.post.PostService;
import com.backend.ggwp.service.RestApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class BbsController {

    private final HttpSession httpSession;
    private final ApiInfo API_INFO;
    private final RestApiService restApiService;
    private final PostService postService;

    @GetMapping("/bbs")
    public String index(Model model) {
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

    @GetMapping("/bbs/top")
    public String top(){

        return "bbs/top";
    }

    @GetMapping("/bbs/write")
    public String write(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "bbs/write";
    }

    @PostMapping("/bbs/write")
    public String writePost(@Validated @ModelAttribute("post") Post post,
                            BindingResult bindingResult,
                            Model model){
        log.info("title {} , author {}, content {} ", post.getTitle(), post.getAuthor(), post.getContent());
        if(bindingResult.hasErrors()){
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            model.addAttribute("userName", post.getAuthor());
            return "redirect:http://localhost:8080/bbs/write";
        }
        //postService.save(post);
        return "redirect:http://localhost:8080/bbs";
    }

    @PostMapping("/searchSummoner")
    public String search(@RequestParam("summonerName")String summonerName){
        return "redirect:http://localhost:3000/search/" + summonerName;
    }

}
