package com.backend.ggwp.email;

import com.backend.ggwp.domain.user.dto.ResetPasswordDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@Slf4j
@RequiredArgsConstructor
public class EmailController {
    private final EmailServiceImpl emailService;

    @ResponseBody
    @PostMapping("/emailTest")
    public String emailTest(@RequestParam String email) throws Exception {
        log.info("email to {}", email);
        String confirm = emailService.sendSimpleMessage(email);
        return confirm;
    }

    @GetMapping("/bbs/emailAuth")
    public String emailAuthPage(Model model) {
        return "bbs/email-auth";
    }

    @PostMapping("/bbs/sendEmail")
    public String sendEmail(@RequestParam String email, Model model) throws Exception {
        log.info("email to {}", email);
        String authString = emailService.sendSimpleMessage(email);
        model.addAttribute("emailAuthDto", new EmailAuthDto(authString));
        return "bbs/email-auth";
    }
}
