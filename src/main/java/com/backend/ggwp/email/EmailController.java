package com.backend.ggwp.email;

import com.backend.ggwp.domain.user.GgwpUser;
import com.backend.ggwp.domain.user.UserService;
import com.backend.ggwp.domain.user.dto.ResetPasswordDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;


@Controller
@Slf4j
@RequiredArgsConstructor
public class EmailController {
    private final EmailServiceImpl emailService;
    private final UserService userService;

    @ResponseBody
    @PostMapping("/emailTest")
    public String emailTest(@RequestParam String email) throws Exception {
        log.info("email to {}", email);
        String confirm = emailService.sendSimpleMessage(email);
        return confirm;
    }

    @GetMapping("/bbs/email/send")
    public String emailSendPage(Model model) {

        EmailAuthDto emailAuthDto = new EmailAuthDto();
        model.addAttribute("emailAuthDto", emailAuthDto);
        return "bbs/email-send";
    }

    @PostMapping("/bbs/email/send")
    public String emailSend(@Validated @ModelAttribute("emailAuthDto") EmailAuthDto emailAuthDto,
                            BindingResult bindingResult,
                            RedirectAttributes ra) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("email dto error : {} ", error);
            }
            return "bbs/email-send";
        }
        String email = emailAuthDto.getEmail();
        Optional<GgwpUser> byEmail = userService.findByEmail(email);
        if(byEmail == null || byEmail.isEmpty()){
            bindingResult.rejectValue("email", "", "해당 이메일 정보가 없습니다.");
            return "bbs/email-send";
        }
        log.info("email to {}", email);
        String authString = emailService.sendSimpleMessage(email);
        emailAuthDto.setAuthString(authString);
        ra.addFlashAttribute("emailAuthDto", emailAuthDto);
        return "redirect:/bbs/email/auth";
    }

    @GetMapping("/bbs/email/auth")
    public String emailAuth(Model model) {
        return "bbs/email-auth";
    }
}
