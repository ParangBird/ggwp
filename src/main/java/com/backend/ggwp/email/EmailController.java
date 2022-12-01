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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


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

    @GetMapping("/bbs/email/send")
    public String emailSendPage() {
        return "bbs/email-send";
    }

    @PostMapping("/bbs/email/send")
    public String emailSend(@RequestParam String email, RedirectAttributes ra) throws Exception {
        log.info("email to {}", email);
        //String authString = emailService.sendSimpleMessage(email);
        ra.addFlashAttribute("emailAuthDto", new EmailAuthDto("authString"));
        return "redirect:/bbs/email/auth";
    }

    @GetMapping("/bbs/email/auth")
    public String emailAuth(Model model) {
        return "bbs/email-auth";
    }
}
