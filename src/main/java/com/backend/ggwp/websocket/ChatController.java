package com.backend.ggwp.websocket;

import com.backend.ggwp.domain.bbs.user.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Slf4j
@Controller
@RequestMapping("/chat")
public class ChatController {
    private final ChatService chatService;

    @PostMapping
    public ChatRoom createRoom(@RequestBody String name) {
        return chatService.createRoom(name);
    }

    @GetMapping
    public String findAllRoom(HttpSession httpSession, Model model) {
        log.info("chatting GET");
        PrincipalDetails details = (PrincipalDetails) httpSession.getAttribute("user");
        if (details != null) {
            model.addAttribute("userName", details.getGgwpUser().getName());
        }
        return "bbs/chat";
    }
}
