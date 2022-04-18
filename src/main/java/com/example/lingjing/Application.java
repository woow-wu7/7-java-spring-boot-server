package com.example.lingjing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 1
// 问题：如何运行整个程序？
// 回答：只需要运行 Application 中的 main 方法即可

// 2
// 包结构
// - 注意：SpringBoot项目中，所有的包都必须是 ( 主程序所在的包 ) 的 ( 同级 或者 子级 ) 才会生效
// - 比如：( controller包 ) 就只能放在和 主程序Application 所在的包 ( com.example.lingjing ) 的 ( 同一层级 或者 子级 )
// - 问题：如果非要不同一层级或子级怎么设置呢？
// - 回答：@SpringBootApplication(scanBasePackages = "com.example") 来指定更大的范围，这里表示 com.example 下的所有包 || @ComponentScan

// 3
// @SpringBootApplication
// - 表示是一个 SpringBoot 应用
// - 主程序类，项目的入口
@SpringBootApplication(scanBasePackages = "com.example.lingjing")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
