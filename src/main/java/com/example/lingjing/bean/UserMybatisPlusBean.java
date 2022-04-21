package com.example.lingjing.bean;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.stereotype.Component;

// 1
// UserPlusBean
// - 测试 mybatis-plus  mapper

// 2
// @TableName
// - @TableName 是 mybatis-plus 的注解
// - 默认情况下 ( 实体类名 ) 需要和 ( 数据库表名 ) 保持一致
// - 默认情况下会将驼峰的实体类名通过 _ 下划线链接，即 user_plus_bean

// 3
// 详见
// Application -> ( @MapperScane )
// UserMybatisPlusBean -> ( @TableName + @TableField )
// UserMybatisPlusMapper -> ( public interface UserMybatisPlusMapper extends BaseMapper<UserMybatisPlusBean> )
// UserMybatisPlusTest -> ( mapper -> selectById  + updateById + deleteById + insert )

@TableName("user")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Component
public class UserMybatisPlusBean {
    public String name;
    public Integer age;
    public String address;

    public Integer id;

    // @TableField
    // - 是 mybatis-plus 的注解
    // - 表示 该属性 在数据库中不存在
    //   - 因为：默认情况下 ( bean所有属性都要和表的字段一一对应 )，少一个都不行
    //   - 这里：指定 other 可以不一一对应
    @TableField(exist = false)
    public String other;
}
