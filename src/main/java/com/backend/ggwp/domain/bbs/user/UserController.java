package com.backend.ggwp.domain.bbs.user;

import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDTO;
import com.backend.ggwp.domain.bbs.user.dto.LoginDto;
import com.backend.ggwp.domain.bbs.user.dto.RegisterDto;
import com.backend.ggwp.domain.bbs.user.dto.ResetPasswordDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@Slf4j
@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @GetMapping("/bbs/loginRedirect")
    public String loginRedirect(HttpServletResponse response) {
        try {
            response.setContentType("text/html; charset=utf-8");
            PrintWriter out = response.getWriter();
            out.print("<script>alert('로그인을 해 주세요!'); location.href='/bbs';</script>");
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "redirect:/bbs";
    }

    @PostMapping("/bbs/login")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto, HttpSession session, HttpServletResponse response) {
        GgwpUserDTO loginUser = userService.login(loginDto);
        if (loginUser == null) {
            log.info("로그인 실패");
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('회원 정보를 확인해주세요!'); location.href='/bbs';</script>");
                out.flush();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "redirect:/bbs";
        }
        session.setAttribute("ggwpUser", loginUser);
        return "redirect:/bbs";
    }


    @GetMapping("/bbs/register")
    public String register(Model model) {
        model.addAttribute("registerDto", new RegisterDto());
        return "bbs/register";
    }

    @PostMapping("/bbs/register")
    public String register(@Validated @ModelAttribute("registerDto") RegisterDto registerDto,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            log.info("retry to register");
            return "bbs/register";
        }
        if (!registerDto.getPassword().equals(registerDto.getPasswordCheck())) {
            log.info("password != passwordCheck");
            bindingResult.rejectValue("passwordCheck", "패스워드 확인 해주세요", "패스워드 확인 해주세요");
            return "bbs/register";
        }
        int duplicateNumber = userService.checkDuplicateUser(registerDto.getUserName(), registerDto.getEmail());

        if (duplicateNumber == UserService.DUPLICATED_USERNAME) {
            log.info("email duplicated");
            bindingResult.rejectValue("email", "이미 가입된 이메일입니다", "이미 가입된 이메일입니다");
            return "bbs/register";
        } else if (duplicateNumber == UserService.DUPLICATED_EMAIL) {
            log.info("userName duplicated");
            bindingResult.rejectValue("userName", "다른 닉네임을 입력해주세요", "다른 닉네임을 입력해주세요");
            return "bbs/register";
        }
        userService.registerUser(registerDto);
        return "redirect:/bbs";
    }

    @GetMapping("/bbs/reset-password")
    public String resetPasswordPage(Model model) {
        model.addAttribute("resetPasswordDto", new ResetPasswordDto());
        return "bbs/reset-password";
    }

    // TODO: 2023-02-28 추후 이메일 보낼때 같이 수정
    @PostMapping("/bbs/reset-password")
    public String resetPassword(@Validated @ModelAttribute("resetPasswordDto")
                                        ResetPasswordDto resetPasswordDto,
                                BindingResult bindingResult) {
        System.out.println("resetPasswordDto = " + resetPasswordDto.getEmail());
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError allError : allErrors) {
                log.info("Error = {}", allError);
            }
            log.info("retry to reset-password");
            return "bbs/reset-password";
        }
        GgwpUserDTO byEmail = null;
        try {
            byEmail = userService.findByEmail(resetPasswordDto.getEmail());
        } catch (Exception e) {
            bindingResult.rejectValue("email", "", "회원정보에 해당 이메일이 존재하지 않습니다.");
            return "bbs/reset-password";
        }

        log.info("이메일 보냄");
        return "redirect:/bbs";
    }


}
