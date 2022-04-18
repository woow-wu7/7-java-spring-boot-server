package com.example.lingjing.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // @RequestMapping(path = "/hello", method = {RequestMethod.GET})
    // @GetMapping(path = "/hello")
    @GetMapping("/hello")
    public String getHello() {
        return "hello word";
    }
}
