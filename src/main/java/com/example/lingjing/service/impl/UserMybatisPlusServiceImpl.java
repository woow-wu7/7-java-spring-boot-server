package com.example.lingjing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.lingjing.bean.UserMybatisPlusBean;
import com.example.lingjing.mapper.UserMybatisPlusMapper;
import com.example.lingjing.service.UserMybatisPlusService;
import org.springframework.stereotype.Service;

// 3
// 详见
// Application -> ( @MapperScan )
// UserMybatisPlusBean -> ( @TableName + @TableField )
// UserMybatisPlusMapper -> ( public interface UserMybatisPlusMapper extends BaseMapper<UserMybatisPlusBean> )
// UserMybatisPlusMapperTest -> ( mapper -> selectById  + updateById + deleteById + insert )
// UserMybatisPlusServer + UserMybatisPlusServerImpl + UserMybatisPlusServiceTest

// 先 extends 在 implements
@Service
public class UserMybatisPlusServiceImpl extends ServiceImpl<UserMybatisPlusMapper, UserMybatisPlusBean> implements UserMybatisPlusService {
}
