package com.example.lingjing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@Slf4j
public class SessionController {

    // 1
    // session的具体认证流程
    // 1.用户提交用户名，密码到服务器
    // 2.服务器认证通过后，在 session 中保存相关数据，比如用户名，角色，登陆时间，等
    // 3.服务器向客户端返回一个 session_id，并写入 cookie
    // 4.客户端以后的每一次请求，都会携带 cookie，即将 session_id 传回服务器
    // 5.服务器收到 session_id，找到之前保存的数据，由此得知用户的身份


    // 2
    // 登录 ------------- 设置 session
    // - 获取到 username 和 password 后
    // - 设置 session
    // 注意
    // - 参数类型：HttpSession
    @PostMapping("/login-test")
    public Map loginTest(
            @RequestBody Map<String, String> body,
            HttpSession session
    ) {
        System.out.println(body);
        String username = body.get("username");
        String password = body.get("password");

        if (Boolean.parseBoolean(username) && Boolean.parseBoolean(password)) {
            session.setAttribute("USER", body); // --------------------- 设置session
        }
        return body;
    }

    // 3
    // 请求 ---------- 获取session
    // 请求其他接口
    // 第一次请求：
    // - 查看 ( 响应头否有 set-cookie - sessionID会自动写入cookie - JSESSIONID )
    // 第二三...请求
    // - 查看 ( 请求头是否有 cookie - JSESSIONID )
    @GetMapping("/get-session")
    public void getCookie(
            HttpServletRequest request
    ) {
        HttpSession session = request.getSession(); // -------------------- 获取session
        Object user = session.getAttribute("USER");
        log.info("session => {}", session);
        log.info("user => {}", user);

        Cookie[] cookies = request.getCookies(); // ----------------------- 获取cookie
        for (Cookie cookie : cookies) {
            log.info("cookie => {}", cookie);
        }
    }
}
