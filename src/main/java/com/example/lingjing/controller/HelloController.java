package com.example.lingjing.controller;

import com.example.lingjing.bean.HelloBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// @RestController = @Controller + @ResponseBody
@Slf4j
@RestController
public class HelloController {

    @Autowired
    HelloBean helloBean;
    // 1
    // helloBean
    // 注册：
    // - a. 在 HelloConfig 中通过 ( @Configuration + @Bean 注册了 )
    // - b. 除了a，也可以在 HelloBean 上通过 ( @Component ) 直接将 HelloBean 注册为容器中的组件，同样通过 ( @AutoWired ) 引入
    // 引入：在这里通过 @Autowired 注入使用
    // 英语：wired 是链接的意思
    // 详见：https://juejin.cn/post/6960187616050282533#heading-21

    // 2
    // @RequestMapping(path = "/hello", method = {RequestMethod.GET})
    // @GetMapping(path = "/hello")
    @GetMapping("/hello")
    public HelloBean getHello() {
        HelloBean res = helloBean.builder().name("woow_wu7").age(100).birthday(new Date()).build();
        log.info("HelloController return value -> {}", res);
        return res;
    }

    // 3
    // 测试：@ConfigurationProperties + @Component 实现配置绑定
    // 详细：
    // - a.在HelloBean中@ConfigurationProperties + @Component
    // - b.在application.properties中设置属性值
    @GetMapping("/hello-@ConfigurationProperties")
    public HelloBean getHelloConfigurationProperties() {
        return helloBean;
    }

    // 4
    // 测试：@PathVariable + @RequestHeader
    @GetMapping("/hello-params/{id}/{name}")
    public HashMap getHelloConfigurationProperties(
            @PathVariable("id") Integer id,
            @PathVariable("name") String name,
            @PathVariable Map<String, String> pathVariables, // 注意Map的类型必须是String，map获取所有path变量

            @RequestHeader("User-Agent") String userAgent, // 一个header
            @RequestHeader Map<String, String> headers // 所有header，map同样只能是String

            // @CookieValue("_ga") String cookieGa // 获取cookie
    ) {
        log.info("id:{}, name:{}, pathVariables:{},userAgent:{}，headers:{}", id, name, pathVariables, userAgent, headers);
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("id", id);
        objectObjectHashMap.put("name", name);
        objectObjectHashMap.put("pathVariables", pathVariables);
        objectObjectHashMap.put("userAgent", userAgent);
        objectObjectHashMap.put("headers", headers);
        // objectObjectHashMap.put("cookieGa", cookieGa);
        return objectObjectHashMap;
    }

}
