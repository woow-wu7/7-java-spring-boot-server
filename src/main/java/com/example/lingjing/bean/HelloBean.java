package com.example.lingjing.bean;

import com.fasterxml.jackson.annotation.*;
import io.swagger.annotations.ApiModel;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

// @Data
// - 是lombok的注解
// - @Data会自动生成 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor

// @Builder
// - 通常情况下 @Data 和 @Builder 会一起使用，因为还是必须写getter/setter
// - 使用
//   - 在 HelloBean 中使用 @Builder
//   - 在 HelloController 中通过 hello2.builder().name("woow_wu7").age(100).build(); 来调用
// - 教程：https://juejin.cn/post/6960187616050282533#heading-21

// @Value
// 只有getter，其他和 @data 一样

// @Slf4j
// - @Slf4j 自动生成该类的 log 静态常量，所以不需要sout了
// - 使用：比如用在controller中 --- log.info("文件名{}. 大小{}KB", originalFilename, size);

@Data
@Builder
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@ToString // 以上都是 lombok的注解

// 1
// @ConfigurationProperties
// - 作用：
//   - @ConfigurationProperties + @Component 实现配置绑定
//   - 可以在 application.properties 中设置容器中该Bean对象组件的值，即属性绑定
// - 扩展
//  - 注意两个注解：@Configuration 和 @ConfigurationProperties


// 2
// @Component
// - 将 Bean 注册为容器组件，具有 SpringBoot 的强大能力

@ConfigurationProperties(prefix = "hello") // @ConfigurationProperties + @Component 实现配置绑定
@Component // ------------- 将 Bean 注册为容器组件，具有 SpringBoot 的强大能力

@JsonPropertyOrder(value = {"age", "name"}) // jackson 保证age属性在name属性前面
@ApiModel("HelloBean - Hello相关的Bean对象") // @Api开头的是 swagger 的注解
public class HelloBean {
    @JsonIgnore // jackson 返回前端该属性时，忽略该属性
    public String name;

    public Integer age;

    @JsonFormat(pattern = "YYYY-MM-DD HH-dd-ss", timezone = "GMT+8") // jackson 格式化时间
    @JsonProperty(value = "birthdayChanged") // jackson 修改返回前端的属性名 birthday -> birthdayChanged
    public Date birthday;

    @JsonInclude(JsonInclude.Include.NON_NULL) // jackson的注解，如果是null，则不返回该字段
    public Nulls isNull;
}
