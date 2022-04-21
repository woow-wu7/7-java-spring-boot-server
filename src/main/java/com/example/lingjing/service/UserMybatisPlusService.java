package com.example.lingjing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.lingjing.bean.UserMybatisPlusBean;

// 1
// 接口
// UserMybatisPlusServer
// - Interface接口 - ( interface ) 也可以继承mybatis-plus的 ( IService )
// - Implements实现类 - (implements service) 继承 ( ServiceImpl<mapper bean> )

// 2
// 接口继承 IService<bean>
// 实现类继承 ServiceImpl<mapper, bean> ，同时实现接口

// 3
// 详见
// Application -> ( @MapperScan )
// UserMybatisPlusBean -> ( @TableName + @TableField )
// UserMybatisPlusMapper -> ( public interface UserMybatisPlusMapper extends BaseMapper<UserMybatisPlusBean> )
// UserMybatisPlusMapperTest -> ( mapper -> selectById  + updateById + deleteById + insert )
// UserMybatisPlusServer + UserMybatisPlusServerImpl + UserMybatisPlusServiceTest

public interface UserMybatisPlusService extends IService<UserMybatisPlusBean> {
}
