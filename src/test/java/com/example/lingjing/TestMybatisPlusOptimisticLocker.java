package com.example.lingjing;

import com.example.lingjing.bean.ProductBean;
import com.example.lingjing.mapper.ProductMapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TestMybatisPlusOptimisticLocker {

    @Autowired
    ProductMapper productMapper;

    @Test
    public void testMybatisPlusOptimisticLocker() {

        ProductBean productMapper1 = productMapper.selectById(1);
        ProductBean productMapper2 = productMapper.selectById(1);

        // 1 获取到的价格
        log.info("1获取到的价格price1 => {}",  productMapper1.getPrice());
        // 2 获取到的价格
        log.info("2获取到的价格price2 => {}", productMapper2.getPrice());


        // 1 将价格 + 10
        productMapper1.setPrice(productMapper1.getPrice() + 10);
        productMapper.updateById(productMapper1); // 更新数据库


        // 2 将价格 - 10
        productMapper2.setPrice(productMapper1.getPrice() - 10);
        productMapper.updateById(productMapper2); // 更新数据库


        ProductBean productMapperEnd = productMapper.selectById(1);
        log.info("最终查询到的价格price => {}",  productMapperEnd.getPrice());
    }
}
