package com.example.lingjing.controller;

import com.example.lingjing.bean.UserBean;
import com.example.lingjing.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

//@Controller
//@ResponseBody
@RestController
// 是上面两个注解的合集，注意：这里不能用 @Controller，不然报错 Circular view path [users]: would dispatch back to the current handler URL [/users] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    // 查
    @GetMapping("/select-user")
    public UserBean getUser(
            @RequestParam(name = "id", required = false) Integer id
    ) {
        log.info("id:{}", id);
        return userService.getUser(id);
    }

    // 增
    // 使用 postman 进行测试
    @PostMapping("/insert-user")
    public Integer addUser(
            @RequestBody Map<String, Object> body
    ) {
        return userService.addUser(body);
    }

    // 删
    @PostMapping("/delete-user")
    public Integer deleteUser(
            @RequestBody Map body
    ) {
        Integer id = (Integer) body.get("id");
        return userService.deleteUser(id);
    }

    // 改
    @PostMapping("/update-user")
    public Integer editUser(
            @RequestBody Map body
    ) {
        return userService.editUser(body);
    }
}
