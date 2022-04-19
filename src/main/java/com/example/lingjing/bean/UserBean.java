package com.example.lingjing.bean;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component // 自动注册为组件，注入容器
@ApiModel("UserBean-用户信息") // @Api开头的是 swagger 的注解
public class UserBean {
    public String name;
    public Integer age;
    public String address;
    public Integer id;
}
