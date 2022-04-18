# SpringBoot

### (1) 相关知识点
```相关知识点

项目初始化
- mac上java安装教程
  - java安装配置：https://juejin.cn/post/6927306093970325517/#heading-15
  - maven安装配置：https://juejin.cn/post/6927306093970325517/#heading-16
  - 注意：如果 maven3.8.5 和 社区版idea 冲突的话，改用 maven3.6.3

打包部署
- 打包 fat-jar
- 打包后的文件：在 target 文件夹中可以找到 jar 包
- 打jar包需要的插件和pom.xml设置：https://juejin.cn/post/6927306093970325517/#heading-13
- 部署相关命令(全)：https://juejin.cn/post/6930627377101979662#heading-11

包结构
  - 注意：SpringBoot项目中，所有的包都必须是 ( 主程序所在的包 ) 的 ( 同级 或者 子级 ) 才会生效
  - 比如：( controller包 ) 就只能放在和 主程序 ( Application ) 所在的包 ( com.example.lingjing ) 的 ( 同一层级 或者 子级 )
  - 问题：如果非要不同一层级或子级怎么设置呢？
  - 回答：@SpringBootApplication(scanBasePackages = "com.example") 来指定更大的范围，这里表示 com.example 下的所有包

配置文件
- 官网说明文档：https://docs.spring.io/spring-boot/docs/current/reference/html/
- application.properties
  - src/main/resources/application.properties
  - src/main/resources/application.yml

pom.xml
- 父项目的作用：请查看pom.xml文件中的 <parent>
- 自定义子项目的版本号： 在当前项目里重写配置，比如：<properties><java.version>1.8</java.version></properties>

插件安装
- lombok
  - 作用：用来简化开发，主要用于自动生成DTO,MODEL，bean对象等的 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
  - 配置：1. 需要下载idea的lonbok插件 2. 需要在pom.xml中安装lombok的maven依赖
  - 使用：详见 HelloBean 
  - 文章：https://juejin.cn/post/6930627377101979662#heading-9

SpringBoot的一些底层注解
- @Configuration + @Bean + @Autowired
- lombock => @Data + @AllArgsConstructor + @NoArgsConstructor + @ToString
```