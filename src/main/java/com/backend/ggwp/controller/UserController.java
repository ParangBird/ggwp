package com.backend.ggwp.controller;

import com.backend.ggwp.config.auth.dto.OauthUser;
import com.backend.ggwp.domain.user.GgwpUser;
import com.backend.ggwp.domain.user.dto.LoginDto;
import com.backend.ggwp.domain.user.dto.RegisterDto;
import com.backend.ggwp.service.UserService;
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
import java.util.List;
import java.util.Optional;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {
    private final HttpSession httpSession;
    private final UserService userService;

    @GetMapping("/bbs/login")
    public String loginPage(Model model) {
        OauthUser user = (OauthUser) httpSession.getAttribute("user");
        if (user != null) {
            model.addAttribute("userName", user.getName());
        }
        return "bbs/login";
    }

    @ResponseBody
    @PostMapping("/bbs/login")
    public String login(@ModelAttribute @Validated LoginDto loginDto,
                        HttpServletRequest request, HttpServletResponse response) {
        String email = loginDto.getEmail();
        String password = loginDto.getPassword();
        Optional<GgwpUser> user = userService.findByEmail(email);
        if (user == null || user.isEmpty() || !user.get().getPassword().equals(password)) {
            try {
                PrintWriter out = null;
                out = response.getWriter();
                out.println("<script>alert('회원 정보가 부정확합니다.'); location.href='/bbs';</script>");
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        HttpSession session = request.getSession();
        session.setAttribute("ggwpUser", user.get());
        return "redirect:/bbs";
    }

    @PostMapping("/bbs/register")
    public String register(@Validated @ModelAttribute("registerDto") RegisterDto registerDto, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            log.info("retry to register");
            return "bbs/register";
        }
        Optional<GgwpUser> dup = userService.findByUserName(registerDto.getUserName());
        if (dup != null && dup.isPresent()) {
            return "중복된 아이디";
        }
        String userName = registerDto.getUserName();
        String password = registerDto.getPassword();
        String email = registerDto.getEmail();
        GgwpUser newGgwpUser = GgwpUser.builder().userName(userName).password(password).email(email).build();
        userService.save(newGgwpUser);
        return "회원가입 성공";
    }

    @GetMapping("/bbs/reset-password")
    public String resetPasswordPage() {
        return "bbs/reset-password";
    }

    @PostMapping("/bbs/reset-password")
    @ResponseBody
    public String resetPassword(@RequestParam("email") String email){
        return email + "에 메일 발송";
    }

    @GetMapping("/bbs/register")
    public String register(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "bbs/register";
    }

    @GetMapping("/logout")
    public String logout() {
        return "bbs/index";
    }

}
