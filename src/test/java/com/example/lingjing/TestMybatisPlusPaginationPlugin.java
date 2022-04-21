package com.example.lingjing;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page; //
import com.example.lingjing.bean.UserMybatisPlusBean;
import com.example.lingjing.mapper.UserMybatisPlusMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

// mybatis-plus 分页插件测试
@SpringBootTest
@Slf4j
public class TestMybatisPlusPaginationPlugin {


    @Autowired
    UserMybatisPlusMapper userMybatisPlusMapper;


    @Test
    public void testPaginationPlugin() {
        Page<UserMybatisPlusBean> objectPage = new Page<>(1, 2); // page对象 current，size

        userMybatisPlusMapper.selectPage(objectPage, null);

        log.info(" objectPage.getRecords() => {}", objectPage.getRecords()); // ----- 查到的数据
        log.info(" objectPage.getTotal() => {}", objectPage.getTotal()); // --------- 总数据条数
        log.info(" objectPage.getPages() => {}", objectPage.getPages()); // --------- 总页码数
        log.info(" objectPage.hasNext() => {}", objectPage.hasNext()); // ----------- 是否有下一页
        log.info(" objectPage.hasPrevious() => {}", objectPage.hasPrevious()); // --- 是否有上一页
    }
}
