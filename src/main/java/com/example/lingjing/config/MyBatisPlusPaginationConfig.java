package com.example.lingjing.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// mybatis-plus 分页设置
@Configuration
public class MyBatisPlusPaginationConfig {

    @Bean
    public MybatisPlusInterceptor myBatisPlusPagination() {

        // 1
        // MybatisPlusInterceptor
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor(); // 拦截器

        // 2
        // PaginationInnerInterceptor

        // 3
        // 向MyBatis-Plus的过滤器链中添加 ( 分页拦截器 )
        // 需要设置数据库类型（ 主要用于分页方言 ）
        interceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL)); // mysql类型

        return interceptor;
    }
}
