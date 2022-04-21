package com.example.lingjing;

import com.example.lingjing.service.UserMybatisPlusService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// 详见
// Application -> ( @MapperScan )
// UserMybatisPlusBean -> ( @TableName + @TableField )
// UserMybatisPlusMapper -> ( public interface UserMybatisPlusMapper extends BaseMapper<UserMybatisPlusBean> )
// UserMybatisPlusTest -> ( mapper -> selectById  + updateById + deleteById + insert )
// UserMybatisPlusServer + UserMybatisPlusServerImpl

@SpringBootTest
@Slf4j
public class UserMybatisPlusServiceTest {

    @Autowired
    UserMybatisPlusService userMybatisPlusService;

    // 查
    @Test
    public void getList() {

    }
}
