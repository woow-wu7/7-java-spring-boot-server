package com.example.lingjing;

import com.example.lingjing.bean.UserPlusBean;
import com.example.lingjing.mapper.UserPlusMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class UserPlusTest {

    @Autowired
    UserPlusMapper userPlusMapper;

    // mapper 相关测试
    // - select -> selectById
    // - insert ->
    @Test
    public void mybatisPlusUserSelectTest() {
        UserPlusBean userPlusBean = userPlusMapper.selectById(1);
        System.out.println(userPlusBean);
    }

    @Test
    public void mybatisPlusUserInsertTest() {
        UserPlusBean userPlusBean1 = new UserPlusBean();
        long id = 22;
        // id
        // - 注意：
        //   - bean对象中id使用long类型，而数据库中id需要使用bigint
        //   - bean long -> mysql bigint
        //        userPlusBean1.toBuilder() // builder() 是 lombok 的 @Builder 的能力
        //                .name("周杰伦2")
        //                .age(80)
        //                .address("beijing")
        //                .id(id)
        //                .build();
        // md遇到builder不生效的问题，待解决
        // todo

        userPlusBean1.setName("xxx");
        userPlusBean1.setAddress("yyy");
        userPlusBean1.setAge(40);


        int insert = userPlusMapper.insert(userPlusBean1);
        log.info("userPlusBean1 => {}", userPlusBean1);
        log.info("insert => {}", insert);
    }
}
