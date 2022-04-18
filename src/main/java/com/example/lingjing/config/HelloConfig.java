package com.example.lingjing.config;

import com.example.lingjing.bean.HelloBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// 1
// @Configuration
// - 作用：告诉SpringBoot这是一个 ( 配置类 ) === xml配置文件
// - 注意：@Configuration 修饰的配置类 HelloConfig 本身也是组件，也会在容器中

// 2
// @Bean
// - 作用：向 ( 容器 ) 中 ( 注册 ) 组件
// - 修改组件名：@Bean(hello2) 这样写可以把注册到容器中的组件重新命名为hello2，而不是用方法名hello1，不传参数时默认组件名是方法名
// 1. 以方法名作为组件的id => user1
// 2. 返回类型就是组件类型 => UserBean
// 3. 返回的值就是组件在容器中的实例 => new UserBean()

// 3
// 文章：https://juejin.cn/post/6960187616050282533#heading-22

@Configuration
public class HelloConfig { // HelloConfig 本身也是组件

    @Bean("hello2")
    public HelloBean hello1() {
        return new HelloBean("woow_wu7", 20);
    }
}
