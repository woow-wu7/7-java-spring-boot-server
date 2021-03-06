package com.example.lingjing;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.lingjing.bean.UserMybatisPlusBean;
import com.example.lingjing.mapper.UserMybatisPlusMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


// 详见
// Application -> ( @MapperScan )
// UserMybatisPlusBean -> ( @TableName + @TableField )
// UserMybatisPlusMapper -> ( public interface UserMybatisPlusMapper extends BaseMapper<UserMybatisPlusBean> )
// UserMybatisPlusMapperTest -> ( mapper -> selectById  + updateById + deleteById + insert )
// UserMybatisPlusServer + UserMybatisPlusServerImpl + UserMybatisPlusServiceTest

@SpringBootTest
@Slf4j
public class UserMybatisPlusMapperTest {

    @Autowired
    UserMybatisPlusMapper userMybatisPlusMapper;


    // 1
    // mapper 相关测试
    // - select -> selectById + selectList
    // - update -> updateById
    // - delete -> deleteById
    // - insert -> insert


    // 查 select single
    @Test
    public void mybatisPlusUserSelectTest() {
        UserMybatisPlusBean userPlusBean = userMybatisPlusMapper.selectById(1);
        System.out.println(userPlusBean);
    }

    // 查 select list
    @Test
    public void mybatisPlusUserSelectTestList() {
        QueryWrapper queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", "woow_wu7");

        List list = userMybatisPlusMapper.selectList(null); // null表示查询所有
        log.info("list => {}", list);
    }


    // 增 insert
    @Test
    public void mybatisPlusUserInsertTest() {
        UserMybatisPlusBean userPlusBean1 = new UserMybatisPlusBean();

        // 2
        // builder() 是 lombok 的 @Builder 的能力
        UserMybatisPlusBean build = userPlusBean1.builder()
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

        int status = userMybatisPlusMapper.insert(build);
        log.info("status => {}", status);
    }

    // 改 update
    @Test
    public void mybatisPlusUserUpdateTest() {
        UserMybatisPlusBean userPlusBean2 = new UserMybatisPlusBean();

        // 修改的就是上面 insert 的数据
        UserMybatisPlusBean build = userPlusBean2.builder()
                .name("AAA")
                .age(900)
                .address("BBB")
                .id(900)
                .build();
        log.info("build => {}", build);
        int status = userMybatisPlusMapper.updateById(build);
        log.info("status => {}", status);
    }

    // 删 delete
    @Test
    public void mybatisPlusUserDeleteTest() {
        int status = userMybatisPlusMapper.deleteById(900);
        log.info("status => {}", status);
    }
}
