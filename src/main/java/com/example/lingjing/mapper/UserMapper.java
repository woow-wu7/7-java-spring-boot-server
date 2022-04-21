package com.example.lingjing.mapper;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lingjing.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Mapper
public interface UserMapper {
    // 1
    // 查
    // mybatis使用方式：注解方式 @Select
    // @Select("select * from user where id=#{id}")
    // public UserBean getUser(Integer id);


    // 2
    // 查
    // mybatis使用方式：xml配置方式
    public UserBean getUser(Integer id);

    // 增
    // 注意：添加数据时，mybatis返回的是数字类型，1表示成功
    public Integer addUser(Map<String, Object> body);

    // 删
    public Integer deleteUser(Integer id);

    // 改
    public Integer editUser(Map body);


    /**
     * @desc 通过 用户ID 查询 用户信息
     * @param page Mybatis-plus 提供的分页对象，必须是第一个参数位置
     * @param id 表数据 id
     * @return page
     */
    // 重要
    // 自定义分页
    public Page<UserBean> selectPageVo(
            @RequestParam("page") Page<UserBean> page,
            @RequestParam("id") Integer id);
}
