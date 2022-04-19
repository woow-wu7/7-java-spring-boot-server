package com.example.lingjing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // Swagger2进行包扫描，扫描 controller，这里填写 controller 的文件夹全路径
                .apis(RequestHandlerSelectors.basePackage("com.example.lingjing.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                // 标题
                .title("7-java-server 使用Swagger2构建RESTful APIs")
                // 描述
                .description("7-java-server Swagger2的接口文档")
                // 作者信息
                .contact(new Contact("woow_wu7", "https://github.com/woow-wu7/7-java-service", "woow_wu7@gmail.com"))
                // 服务网址
                .termsOfServiceUrl("http://120.53.220.141:81/admin-home")
                .version("1.0")
                .build();
    }
}
