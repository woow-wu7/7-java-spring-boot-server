package com.example.lingjing;

import com.example.lingjing.bean.UserMybatisPlusBean;
import com.example.lingjing.service.UserMybatisPlusService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    // 查 list
    @Test
    public void getList() {
        List<UserMybatisPlusBean> list = userMybatisPlusService.list();
        log.info("list => {}", list);
    }
}
