package com.example.lingjing;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.lingjing.bean.UserBean;
import com.example.lingjing.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestCustomPagination {

    @Autowired
    UserMapper userMapper;

    @Test
    public void testCustomPagination() {
        Page<UserBean> objectPage = new Page<UserBean>(1, 2);
        userMapper.selectPageVo(objectPage, 1);

        log.info(" objectPage.getRecords() => {}", objectPage.getRecords()); // ----- 查到的数据
        log.info(" objectPage.getTotal() => {}", objectPage.getTotal()); // --------- 总数据条数
        log.info(" objectPage.getPages() => {}", objectPage.getPages()); // --------- 总页码数
        log.info(" objectPage.hasNext() => {}", objectPage.hasNext()); // ----------- 是否有下一页
        log.info(" objectPage.hasPrevious() => {}", objectPage.hasPrevious()); // --- 是否有上一页
    }
}
