package com.example.lingjing.bean;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

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
@ToString
public class HelloBean {
    public String name;
    public Integer age;
}
