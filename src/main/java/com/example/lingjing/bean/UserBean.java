package com.example.lingjing.bean;

import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component // 自动注册为组件，注入容器
public class UserBean {
    public String name;
    public Integer age;
    public String address;
    public Integer id;
}
