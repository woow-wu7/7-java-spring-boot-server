package com.example.lingjing.bean;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.*;
import org.springframework.stereotype.Component;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
@TableName("goods") // mybatis-plus 查询的表名
public class ProductBean {

    public Integer price;
    public String name;
    public Integer id;

    @Version // mybatis-plus 标识乐观锁版本号
    public Integer version;
}
