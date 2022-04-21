package com.example.lingjing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.lingjing.bean.UserPlusBean;
import org.apache.ibatis.annotations.Mapper;

// UserPlusMapper
// - 用来测试 mybatis-plus 的  ( extends BaseMapper<bean对象> )，bean对象中的属性和数据库一一对应
// - 测试在 UserPlusTest 中
@Mapper
public interface UserPlusMapper extends BaseMapper<UserPlusBean> {

}
