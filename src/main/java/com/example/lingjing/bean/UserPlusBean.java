package com.example.lingjing.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Component;


// @TableName
// - @TableName 是 mybatis-plus 的注解
// - 默认情况下 ( 实体类名 ) 需要和 ( 数据库表名 ) 保持一致
// - 默认情况下会将驼峰的实体类名通过 _ 下划线链接，即 user_plus_bean
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder(toBuilder = true)
@Component
@TableName("user")
public class UserPlusBean {
    public String name;
    public Integer age;
    public String address;

    public Long id;

    // @TableField
    // - 是 mybatis-plus 的注解
    // - 表示 该属性 在数据库中不存在
    //   - 因为：默认情况下 所有属性都要和表的字段一一对应，少一个都不行
    //   - 这里：指定 other 可以不一一对应
    @TableField(exist = false)
    public String other;
}
