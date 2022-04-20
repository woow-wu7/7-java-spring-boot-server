package com.example.lingjing.controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.lingjing.utils.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@RestController
@Slf4j
public class JwtController {

    // 1
    // jwt 直接测试
    @GetMapping("/jwt")
    public void testJwt() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        Calendar instance = Calendar.getInstance();
        instance.add(Calendar.SECOND, 2000); // 当前时间 + 2000s
        Date expiresTime = instance.getTime();

        Algorithm signatureString = Algorithm.HMAC256("thisIsRandomString");

        // 1
        // 生成 JWT
        String token = JWT.create() // 创建 jwt，jwt由三部分组成 ( header.payload.signature )
                .withHeader(objectObjectHashMap) // ---------------- header
                .withClaim("username", "woow_wu7") // -- payload
                .withClaim("password", 123)
                .withExpiresAt(expiresTime) // 过期时间
                .sign(signatureString);// - signature
        log.info("token => {}", token);


        // 2
        // 验证 JWT
        // verifyInstance 生成验证对象
        JWTVerifier verifyInstance = JWT.require(signatureString).build();
        DecodedJWT verify = verifyInstance.verify(token); // 验证token
        String username = verify.getClaim("username").asString(); // -- 通过token，获取username，注意过期时间，过期后是拿不到username的
        Integer password = verify.getClaim("password").asInt(); // ---- 通过token，获取age
        log.info("传入token，验证token中的username => {}", username);
        log.info("传入token，验证token中的password => {}", password);

        Date expiresAt = verify.getExpiresAt(); // ----------------------- 通过token，获取过期时间
        log.info("token的过期时间 => {}", expiresAt);
    }

    // 2
    // jwt 封装测试
    @GetMapping("/jwt-login")
    public Object getJwtUser(
            @RequestParam String username,
            @RequestParam String password
    ) {
        HashMap<Object, Object> stringObjectHashMap = new HashMap<>(); // ------------------- 结果map

        HashMap<Object, Object> paramsMap = new HashMap<>();
        paramsMap.put("username", username);
        paramsMap.put("password", password);
        String token = JwtUtil.getToken(paramsMap); // 生成token

        try {
            stringObjectHashMap.put("msg", "请求成功");
            stringObjectHashMap.put("token", token);
        } catch (Exception e) {
            stringObjectHashMap.put("msg", "请求失败");
            stringObjectHashMap.put("data", e.getMessage());

        }
        return stringObjectHashMap;
    }
}
