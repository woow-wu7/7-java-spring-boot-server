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
- 优先级
  - application.properties > application.yml

pom.xml
- 父项目的作用：请查看pom.xml文件中的 <parent>
- 自定义子项目的版本号： 在当前项目里重写配置，比如：<properties><java.version>1.8</java.version></properties>

插件安装
- lombok
  - 作用：用来简化开发，主要用于自动生成DTO,MODEL，bean对象等的 @Getter @Setter @ToString @EqualsAndHashCode @RequiredArgsConstructor
  - 配置：1. 需要下载idea的lonbok插件 2. 需要在pom.xml中安装lombok的maven依赖
  - 使用：详见 HelloBean 
  - 文章：
    - https://juejin.cn/post/6930627377101979662#heading-9
    - https://juejin.cn/post/6960187616050282533#heading-21
- MyBatisX
  - mybatis的xml文件和mapper类方法间的跳转
- devtools
  - 实现重新构建
  - 快捷键：command + f9 则可以重新构建，不需要在重新run
  - 要实现真正的热更新：https://juejin.cn/post/6960187616050282533#heading-25

SpringBoot常用注解
- @Configuration + @Bean + @Autowired + @Builder
- @ConfigurationProperties + @Compoennt + ( @EnableConfiguraionProperties )
- @Import + @Component + @Bean
- controller相关
  - @GetMapping + @PostMapping ...
  - @RequestParam + @ReqeustBody + @RequestPart + @RequestHeader + @RequestAttribute`
  - @PathVariable + @CookieValue
  - @ResponseBody 详见 UploadController 3 的注释
- lombock => @Data + @AllArgsConstructor + @NoArgsConstructor + @ToString + @Value +  @Builder + @Slf4j


静态资源访问
- 静态资源目录：在 src/main/resrouces 文件夹下的 ( static ) ( public ) ( resources ) ( META-INF/resources ) 四个文件夹都可以
- 如何访问：通过 `服务地址/静态资源名称` 来访问
- 原理：
  - 结果描述：( 动态资源，比如一个controller的地址是 /a.jpg )，而静态资源文件夹中也有 ( a.jpg )，此时命中的是 controller，而不是静态资源
  - 原因：静态资料匹配 `/**`，也就是说如果 controller 不能处理的情况，才会交给静态资源处理器，都找不到则404
  - 文章：https://juejin.cn/post/6932097247735709709
- 静态资源反问前缀
  - 设置：在 application.yaml 中通过 `spring.mvc.static-path-pattern=/resources/**` 来设置前缀 resoruce
  
数据库相关 ( 分四步 )
- 第一步：pom.xml中安装相关maven
  - spring-boot-starter-jdbc
    - 该场景启动器的主要作用：具有 ( 事务，jdbc，数据源 )
    - 不包含：数据库驱动，因为SpringBoot并不知道我们使用什么数据库，所以需要安装数据库驱动，比如 mysql数据库驱动
  - mysql-connector-java
    - mysql数据库驱动
    - 版本需要和你安装的mysql版本保持一致，即驱动版本和数据库版本要一致
  - mybatis-spring-boot-starter
    - mybatis 操作数据库 
    - mybatis有两种用法：1. 纯注解的方式 2.xml配置的方式
- 第二步：在 application.yaml 中做数据库相关的配置
- 第三步：docker安装mysql
  - 文章：https://juejin.cn/post/6892390655126241287#heading-12
- 第四步：mybatis 访问数据库，并操作数据
  - (安装和配置)文章：https://juejin.cn/post/6929145638898794503/#heading-22
  - idea插件：MyBatisX，可以在 xml 和 类方法 两者中做跳转
  
Swagger
- 作用：自动生成 ( 接口文档 ) 及 ( 自测工具 )，注解以 ( @Api开头 )
- 文章：https://juejin.cn/post/6934274450514771982#heading-3
- 注意：Swagger2 3.0 只需要 ( springfox-boot-starter ) 就可以了 
- 报错--：安装配置好 swagger2 3.0 后报错：Failed to start bean 'documentationPluginsBootstrapper'; nested exception is java.lang.NullPointerException
- 解决--：在主程序类上添加 @EnableWebMvc 注解
- 访问--：本地服务地址或者远程服务器地址/swagger-ui/index.html

jackson
- spring-boot-starter-web 场景启动器中已经包含了 jackson
- 如果不使用 spring-boot-starter-web 则自己安装 spring-boot-starter-json
- 文章：https://juejin.cn/post/6935081135114289188#heading-14
- 对比：fastjson + gson + jackson

拦截器 Interceptor
- 步骤
  - 1. implements 实现一个 HandlerInterceptor 拦截类
       - 重写 preHandle 方法
       - 重写 postHandle 方法
       - 重写 afterCompletion 方法
  - 2. implements 实现一个 WebMvcConfigurer 配置类
       - 重写 addInterceptors 方法，在里面添加拦截规则，即 ( 拦截 和 放行 ) 的路径即可

上传文件       
- maven依赖：spring-boot-starter-thymeleaf 返回一个HMTL - web相关
- 文章：https://juejin.cn/post/6932097247735709709#heading-18
- 流程
  - 1. controller的注解：必须是@Controller，而不能是@RestController，因为要返回html
  - 2. controller需要一个 ( 获取上传页面的path ) 和 ( 上传文件的path )
  - 3. 上传文件的参数注解： @RequestPart
  - 4. 上传的文件参数类型： MultipartFile
  - 5. ( html中的input的name属性 - name="single" ) 需要和 (  @RequestPart("single")的参数名 ) 一致，比如都是 single
  - 6. html 放在 src/main/resources/templates 中
- 扩展
  - 问题：如果一个controller，一些页面要返回html，一些又要返回return的内容，怎么办？
  - 等价：如果整个 controller 的注解是 ( @Controller - 返回html )，但是某些方法要 ( 返回数据 ) 怎么办？
  - 回答：
    - @ResponseBody 用在单独的方法上即可返回数据，而不是html
    - 需要用 @Controller注解controller返回html，然后在要返回的return的方法上加上 ( @ResponseBody ) 来返回return后面的内容

配置绑定
  - 1. ( @ConfigurationProperties + @Component -- 作用于Bean对象 ) + ( application.properties中设置属性值 )
  - 2. ( @EnableConfigurationProperties(HelloBean.class) -- 作用于 配置类 ) 只能用在 ( 配置类中 )，即通过 @Configuration 注解修饰的类
  - 案例：查看 HelloBean 和 HelloConfig
``` 

### (2) 快捷键

```快捷键
格式化 -------------------------- command + option + L
参数提示 ------------------------ command + p
打印 --------------------------- sout
删除没有使用到的引入的文件或依赖 ---- control + options + o
Build Project ----------------- command + F9
报错时-更多选项 + 自动生成变量 ---- optiion + enter
```