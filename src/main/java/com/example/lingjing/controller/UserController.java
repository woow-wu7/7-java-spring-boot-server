package com.example.lingjing.controller;

import com.example.lingjing.bean.UserBean;
import com.example.lingjing.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@ResponseBody
@RestController // 是上面两个注解的合集，注意：这里不能用 @Controller，不然报错 Circular view path [users]: would dispatch back to the current handler URL [/users] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public UserBean getUser(
            @RequestParam(name = "id", required = false) Integer id
    ) {
        log.info("id:{}", id);
        return userService.getUser(id);
    }
}
