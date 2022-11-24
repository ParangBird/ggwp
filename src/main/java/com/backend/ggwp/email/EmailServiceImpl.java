package com.backend.ggwp.email;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.mail.Message;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender emailSender;

    public static final String ePw = createKey();

    private MimeMessage createMessage(String to) throws Exception {
        log.info("보내는 대상 : {}", to);
        log.info("인증 번호 : {}", ePw);
        MimeMessage message = emailSender.createMimeMessage();
        message.addRecipients(Message.RecipientType.TO, to);
        message.setSubject("GGWP 비밀번호 찾기");

        String msg = "";
        msg += "<div style='margin:100px;'>";
        msg += "<h1> 안녕하세요 GGWP입니다. </h1>";
        msg += "<br>";
        msg += "<p>아래 코드를 회원가입 창으로 돌아가 입력해주세요<p>";
        msg += "<br>";
        msg += "<p>감사합니다!<p>";
        msg += "<br>";
        msg += "<div align='center' style='border:1px solid black; font-family:verdana';>";
        msg += "<h3 style='color:blue;'>회원가입 인증 코드입니다.</h3>";
        msg += "<div style='font-size:130%'>";
        msg += "CODE : <strong>";
        msg += ePw + "</strong><div><br/> ";
        msg += "</div>";
        message.setText(msg, "utf-8", "html");//내용
        message.setFrom(new InternetAddress("properties email쓰세용!", "Babble"));//보내는 사람
        return message;
    }


    @Override
    public String sendSimpleMessage(String to) throws Exception {
        return null;
    }

    private static String createKey() {
        return null;
    }

}
