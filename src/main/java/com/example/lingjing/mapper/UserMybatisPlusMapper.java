package com.example.lingjing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lingjing.bean.UserMybatisPlusBean;
import org.apache.ibatis.annotations.Mapper;

// UserPlusMapper
// - 用来测试 mybatis-plus 的  ( extends BaseMapper<bean对象> )，bean对象中的属性和数据库一一对应
// - 测试在 UserMybatisPlusTest 中

// 详见
// Application -> ( @MapperScan )
// UserMybatisPlusBean -> ( @TableName + @TableField )
// UserMybatisPlusMapper -> ( public interface UserMybatisPlusMapper extends BaseMapper<UserMybatisPlusBean> )
// UserMybatisPlusMapperTest -> ( mapper -> selectById  + updateById + deleteById + insert )
// UserMybatisPlusServer + UserMybatisPlusServerImpl + UserMybatisPlusServiceTest

@Mapper
public interface UserMybatisPlusMapper extends BaseMapper<UserMybatisPlusBean> {

}
