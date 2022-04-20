package com.example.lingjing.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

// 1
// 1. @RestController = @Controller + @ResponseBody
// 2.
// 问题：如果一个controller，一些页面要返回html，一些又要返回return的内容，怎么办？
// 回答：需要用 @Controller注解controller返回html，然后在要返回的return的方法上加上 ( @ResponseBody ) 来返回return后面的内容

// 2
// 注意区分
// - @RequestParam
// - @RequestBody
// - @RequestPart

@Controller // 注意：这里要返回 html，所以不用 @RestController
@Slf4j
public class UploadController {

    // 1
    // getUploadPage 上传页面，注意是 GetMapping
    @GetMapping("/upload-page")
    public String getUploadPage() {
        // 1. 这里返回 "upload-page" 的是 resources/templates/upload-page.html
        // 2. 需要安装 spring-boot-starter-thymeleaf 这个maven依赖
        return "upload-page"; // 返回 html
    }

    // 2
    // 上传接口 - 前后端未分离
    @PostMapping("/upload")
    public String upload(
            @RequestPart("single") MultipartFile single,
            @RequestPart("multiple") MultipartFile[] multipleList
    ) throws IOException {

        // a. 单文件，保存到static文件夹中
        if (!single.isEmpty()) {
            String singleFileName = single.getOriginalFilename(); // 获取原始文件名
            log.info("singleFileName: {}", singleFileName);

            // single.transferTo() 将single文件转存到...文件夹中
            single.transferTo(new File("/Users/wuxia/work/personal/back_end/7-java-server/src/main/resources/static/" + singleFileName));
        }

        // b. 多文件，保存到static文件夹中
        if (multipleList.length > 0) {
            for (MultipartFile file : multipleList) { // for 循环
                String multipleFileName = file.getOriginalFilename();
                long size = file.getSize() / 1024; // 文件大小，默认但是为字节，1MB = 1024KB = 1024 * 1024 byte；这里size则为MB
                log.info("文件名{}. 大小{}KB", multipleFileName, size);
                file.transferTo(new File("/Users/wuxia/work/personal/back_end/7-java-server/src/main/resources/static/" + multipleFileName));
            }
        }

        return "upload-page"; // 这里上传接口完成后，返回上传页面
    }

    // (3)
    // 前后端分离的接口
    // 注意点
    // 1. consumes 一定要设置成 "multipart/form-data" 因为前端 antd 中的 Upload 组件是用的 form-data 方式在上传
    // 2. 前端上传时 Upload 组件一定要设置 name 属性，因为 name 的值是和这里的 @RequestPart("前端name属性的值") 一一对应
    // 3. consume 是消费的意思
    @PostMapping(value = "/frontendUpload", consumes = "multipart/form-data")
    @ResponseBody
    // @ResponseBody
    // - 因为：整个 controller 的注解是 @Controller 返回 html
    // - 所以：如果要返回非html的数据，需要在方法上单独使用 @ResponseBody
    public String frontendUpload(
            // @RequestParam("file") MultipartFile avatars
            @RequestPart("file") MultipartFile avatars
    ) {
        System.out.println(avatars);
        return "上传成功";
    }
}
