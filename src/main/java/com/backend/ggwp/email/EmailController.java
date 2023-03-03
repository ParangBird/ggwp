package com.backend.ggwp.email;

import com.backend.ggwp.domain.user.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@Slf4j
@RequiredArgsConstructor
public class EmailController {
    private final EmailServiceImpl emailService;
    private final UserService userService;

    @GetMapping("/bbs/email/send")
    public String emailSendPage(Model model) {
        EmailAuthDTO emailAuthDTO = new EmailAuthDTO();
        model.addAttribute("emailAuthDTO", emailAuthDTO);
        return "email/email-send";
    }

    /*@PostMapping("/bbs/email/send")
    public String emailSend(@Validated @ModelAttribute("emailAuthDto") EmailAuthDTO emailAuthDto,
                            BindingResult bindingResult,
                            RedirectAttributes ra) throws Exception {
        if (bindingResult.hasErrors()) {
            List<ObjectError> allErrors = bindingResult.getAllErrors();
            for (ObjectError error : allErrors) {
                log.info("email dto error : {} ", error);
            }
            return "email/email-send";
        }
        String email = emailAuthDto.getEmail();
        Optional<GgwpUser> byEmail = userService.findByEmail(email);
        if (byEmail == null || byEmail.isEmpty()) {
            bindingResult.rejectValue("email", "", "해당 이메일 정보가 없습니다.");
            return "email/email-send";
        }
        if (byEmail.get().isEmailAuth()) {
            bindingResult.rejectValue("email", "", "이미 인증된 이메일입니다.");
            return "email/email-send";
        }
        log.info("email to {}", email);
        String authString = emailService.sendSimpleMessage(email);
        emailAuthDto.setAuthString(authString);
        ra.addFlashAttribute("emailAuthDto", emailAuthDto);
        return "redirect:/bbs/email/auth";
    }

    @GetMapping("/bbs/email/auth")
    public String emailAuthPage(@ModelAttribute("emailAuthDto") EmailAuthDTO emailAuthDto, HttpSession session) {
        log.info("emailAuthDto 전달 : {} 과 {} ", emailAuthDto.getEmail(), emailAuthDto.getAuthString());
        session.setAttribute("emailAuthDto", emailAuthDto);
        return "email/email-auth";
    }

    @ResponseBody
    @PostMapping("/emailTest")
    public String emailTest(@RequestParam String email) throws Exception {
        log.info("email to {}", email);
        String confirm = emailService.sendSimpleMessage(email);
        return confirm;
    }

    @PostMapping("/bbs/email/auth")
    public String emailAuth(@RequestParam("userAuthString") String userAuthString,
                            HttpServletResponse response,
                            Model model, HttpSession session) throws IOException {
        EmailAuthDto emailAuthDto = (EmailAuthDto) session.getAttribute("emailAuthDto");
        String authString = emailAuthDto.getAuthString();
        log.info("유저 입력 {} vs 정답 {}", userAuthString, authString);
        if (!authString.equals(userAuthString)) {
            log.info("정답 : {} 인데, 제출 {}", authString, userAuthString);
            model.addAttribute("emailAuthDto", emailAuthDto);
            // 이때 contentType을 먼저하지 않으면, 한글이 깨질 수 있습니다.
            response.setContentType("text/html; charset=euc-kr");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('인증번호가 틀립니다'); </script>");
            out.flush();
            return "email/email-auth";
        }
        GgwpUser authedUser = userService.findByEmail(emailAuthDto.getEmail()).get();
        authedUser.setEmailAuth(true);
        userService.save(authedUser);
        log.info("인증 성공 !! ! !");
        return "redirect:/bbs";
    }*/
}
