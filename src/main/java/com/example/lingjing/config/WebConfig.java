package com.example.lingjing.config;


import com.example.lingjing.interceptor.GlobalInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        WebMvcConfigurer.super.addInterceptors(registry);
        registry.addInterceptor(new GlobalInterceptor())
                .addPathPatterns("/**")
                // addPathPatterns =====> 拦截所有请求，包括静态资源
                .excludePathPatterns("/", "/login", "css/**", "/fonts/**", "/images/**", "/js/**");
                // excludePathPatterns => 需要放行的路径
    }
}
