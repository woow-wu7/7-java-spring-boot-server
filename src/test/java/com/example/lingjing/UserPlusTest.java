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


    // 1
    // mapper 相关测试
    // - select -> selectById
    // - update -> updateById
    // - delete -> deleteById
    // - insert -> insert


    // 查 select
    @Test
    public void mybatisPlusUserSelectTest() {
        UserPlusBean userPlusBean = userPlusMapper.selectById(1);
        System.out.println(userPlusBean);
    }

    // 增 insert
    @Test
    public void mybatisPlusUserInsertTest() {
        UserPlusBean userPlusBean1 = new UserPlusBean();

        // 2
        // builder() 是 lombok 的 @Builder 的能力
        UserPlusBean build = userPlusBean1.builder()
                .name("aaa")
                .age(900)
                .address("bbb")
                .id(900)
                .build();
        log.info("build => {}", build);

        // 3
        // 遇到问题
        // - 问题：lombok 的 builder() 不生效？
        // - 原因：builder()是有返回值的，返回值build才是最终设置过后的值，而不是userPlusBean1

        int status = userPlusMapper.insert(build);
        log.info("status => {}", status);
    }

    // 改 update
    @Test
    public void mybatisPlusUserUpdateTest() {
        UserPlusBean userPlusBean2 = new UserPlusBean();

        // 修改的就是上面 insert 的数据
        UserPlusBean build = userPlusBean2.builder()
                .name("AAA")
                .age(900)
                .address("BBB")
                .id(900)
                .build();
        log.info("build => {}", build);
        int status = userPlusMapper.updateById(build);
        log.info("status => {}", status);
    }

    // 删 delete
    @Test
    public void mybatisPlusUserDeleteTest() {
        int status = userPlusMapper.deleteById(900);
        log.info("status => {}", status);
    }
}
