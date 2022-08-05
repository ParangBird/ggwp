package com.backend.ggwp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bbs")
public class BbsController {
    @GetMapping("")
    public String index() {
        return "bbs/index";
    }
    @GetMapping("/login")
    public String login(){
        return "bbs/login";
    }
}
