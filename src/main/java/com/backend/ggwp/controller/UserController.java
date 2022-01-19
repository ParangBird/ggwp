package com.backend.ggwp.controller;

import com.backend.ggwp.domain.entity.user.User;
import com.backend.ggwp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseBody
    @GetMapping("/api/login")
    public String login(HttpServletRequest request){
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String password = request.getParameter("password");
        System.out.println("password = " + password);
        Optional<User> user = userService.findByUserName(username);
        System.out.println("user.get().getPassword() = " + user.get().getPassword());
        if (user.isPresent()) {
            if (user.get().getPassword().equals(password)) {
                System.out.println("UserController.login true");
                return "SUCCESS";
            }
        }
        System.out.println("UserController.login false");
        return "FAIL";
    }

    @PostMapping("/register")
    public void register(User user){
        userService.save(user);
    }
}
