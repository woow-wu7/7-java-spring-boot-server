package com.example.lingjing;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

@Slf4j
public class JwtTest {

    // 直接测试
    @Test
    public void testJwt() {
        HashMap<String, Object> objectObjectHashMap = new HashMap<>();

        Calendar instance = Calendar.getInstance(); // 实例
        instance.add(Calendar.SECOND, 2000); // 当前时间 + 2000s
        Date expiresTime = instance.getTime(); // 获取过期时间

        Algorithm signatureString = Algorithm.HMAC256("thisIsRandomString"); // 算法签名字符串

        // 1
        // 生成 JWT
        String token = JWT.create() // 创建 jwt，jwt由三部分组成 ( header.payload.signature )
                .withHeader(objectObjectHashMap) // ---------------- header
                .withClaim("username", "woow_wu7") // -- payload
                .withClaim("password", 123)
                .withExpiresAt(expiresTime) // 过期时间
                .sign(signatureString);// -------------------------- signature
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


    // 3
    // 装的JWT - 在 src/main/java/com.example.lingjing/utils/JwtUtil 中
}
