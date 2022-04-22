package com.example.lingjing.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusOptimisticLockerConfig {

    @Bean
    public MybatisPlusInterceptor myBatisPlusOptimisticLocker() {
        // 1
        // MybatisPlusInterceptor
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor(); // 拦截器

        // 3
        // 向MyBatis-Plus的过滤器链中添加 ( 乐观锁拦截器 )
        // 注意要想 bean 中添加 @Version 注解
        interceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor()); // 添加乐观锁插件

        return interceptor;
    }

}
