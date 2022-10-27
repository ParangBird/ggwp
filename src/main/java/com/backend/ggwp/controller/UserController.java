package com.backend.ggwp.controller;

import com.backend.ggwp.config.auth.dto.SessionUser;
import com.backend.ggwp.domain.repository.UserRepository;
import com.backend.ggwp.domain.user.User;
import com.backend.ggwp.domain.user.dto.LoginDto;
import com.backend.ggwp.domain.user.dto.RegisterDto;
import com.backend.ggwp.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final HttpSession httpSession;
    private final UserService userService;
    @GetMapping("/bbs/login")
    public String loginPage(Model model){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "bbs/login";
    }

    @ResponseBody
    @PostMapping("/bbs/login")
    public String login(@ModelAttribute @Validated LoginDto loginDto,
                        HttpServletRequest request, HttpServletResponse response){
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        Optional<User> user = userService.findByEmail(email);
        if(user == null || user.isEmpty() || !user.get().getPassword().equals(password)){
            try {
                PrintWriter out = null;
                out = response.getWriter();
                out.println("<script>alert('해당 게시글이 존재하지 않습니다.'); location.href='/bbs';</script>");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("ggwpUser", user.get());
        return "redirect:/bbs";
    }

    @ResponseBody
    @PostMapping("/bbs/register")
    public String register(@ModelAttribute @Validated RegisterDto registerDto){
        Optional<User> dup = userService.findByUserName(registerDto.getUserName());
        if(dup != null && dup.isPresent()){
            return "중복된 아이디";
        }
        String userName = registerDto.getUserName();
        String password = registerDto.getPassword();
        String email = registerDto.getEmail();
        User newUser = User.builder().userName(userName).password(password).email(email).build();
        userService.save(newUser);
        return "회원가입 성공";
    }

    @GetMapping("/bbs/reset-password")
    public String resetPassword(){
        return "bbs/reset-password";
    }

    @GetMapping("/bbs/register")
    public String register(){
        return "bbs/register";
    }

    @GetMapping("/logout")
    public String logout(){
        return "bbs/index";
    }

}
