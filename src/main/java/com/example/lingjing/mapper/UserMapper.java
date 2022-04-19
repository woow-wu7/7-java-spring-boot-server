package com.example.lingjing.mapper;


import com.example.lingjing.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    public UserBean getUser(Integer id);
}
