package com.backend.ggwp.email;

import com.backend.ggwp.domain.bbs.user.user.GgwpUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class EmailAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("{} Email 인증 확인", request.getRequestURI());
        HttpSession session = request.getSession();
        if (session.getAttribute("ggwpUser") != null) {
            GgwpUser ggwpUser = (GgwpUser) session.getAttribute("ggwpUser");
            if (!ggwpUser.isEmailAuth()) {
                log.info("사용자가 이메일 인증 안 됐음");
            }
            try {
                response.setContentType("text/html; charset=utf-8");
                PrintWriter out = response.getWriter();
                out.print("<script>alert('이메일 인증을 먼저 해 주세요.'); location.href='/bbs';</script>");
                out.flush();
                out.close();
                return false;
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (session.getAttribute("user") != null) {

        }
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("{} Email 인증 확인됨", request.getRequestURI());
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
