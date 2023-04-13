package com.backend.ggwp.email;

import com.backend.ggwp.domain.bbs.user.user.UserService;
import com.backend.ggwp.domain.bbs.user.dto.GgwpUserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


@Controller
@Slf4j
@RequiredArgsConstructor
public class EmailController {
    private final EmailServiceImpl emailService;
    private final UserService userService;
    private final HttpSession session;

    @GetMapping("/bbs/email/send")
    public String emailSendPage(Model model) {
        EmailAuthDto emailAuthDTO = new EmailAuthDto();
        model.addAttribute("emailAuthDTO", emailAuthDTO);
        return "email/email-send";
    }

    @PostMapping("/bbs/email/send")
    public String emailSend(@Validated @ModelAttribute("emailAuthDTO") EmailAuthDto emailAuthDTO,
                            BindingResult bindingResult,
                            RedirectAttributes ra) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("email dto error : {} ", error);
            }
            return "email/email-send";
        }
        String email = validEmailCheck(emailAuthDTO, bindingResult);
        if (email == null) {
            return "email/email-send";
        }
        log.info("email to {}", email);
        String authString = emailService.sendSimpleMessage(email);
        emailAuthDTO.setAuthString(authString);
        session.setAttribute("emailAuthDTO", emailAuthDTO);
        return "redirect:/bbs/email/auth";
    }

    private String validEmailCheck(EmailAuthDto emailAuthDTO, BindingResult bindingResult) {
        String email = emailAuthDTO.getEmail();
        GgwpUserDto byEmail = null;
        try {
            byEmail = userService.findByEmail(email);
        } catch (Exception e) {
            bindingResult.rejectValue("email", "", "해당 이메일 정보가 없습니다.");
            return null;
        }
        if (byEmail.getEmailAuth()) {
            bindingResult.rejectValue("email", "", "이미 인증된 이메일입니다.");
            return null;
        }
        return email;
    }

    @GetMapping("/bbs/email/auth")
    public String emailAuthPage() {
        return "email/email-auth";
    }

    @PostMapping("/bbs/email/auth")
    public String emailAuth(@RequestParam("userAuthString") String userAuthString,
                            HttpServletResponse response, Model model) throws IOException {
        EmailAuthDto emailAuthDTO = (EmailAuthDto) session.getAttribute("emailAuthDTO");
        String authString = emailAuthDTO.getAuthString();
        if (!authString.equals(userAuthString)) {
            model.addAttribute("emailAuthDTO", emailAuthDTO);
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('인증번호가 틀립니다'); </script>");
            out.flush();
            return "email/email-auth";
        }
        GgwpUserDto authedUser = userService.findByEmail(emailAuthDTO.getEmail());
        authedUser.authUser();
        userService.save(authedUser);
        log.info("인증 성공 !! ! !");
        return "redirect:/bbs";
    }
}
