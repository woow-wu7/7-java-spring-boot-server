package com.example.lingjing;

import com.example.lingjing.bean.HelloBean;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

@SpringBootTest
public class AllTest {

    @Autowired
    HelloBean helloBean;

    // 1
    // @DisplayName 表示给测试方法取个名字
    // @disabled 表示该测试方法不执行
    @DisplayName("@DisplayNam -> 给测试方法取个名字 -> all1")
    @Test
    @Disabled
    void all1() {
        System.out.println("@displayName - 给测试 ( 方法或者 ) 类取个名字 1");
    }

    @DisplayName("@DisplayNam -> 给测试方法取个名字 -> all2")
    @Test
    void all2() {
        System.out.println("@displayName - 给测试 ( 方法或者 ) 类取个名字 2");
    }


    // 2
    // @BeforeEach 在每个单元测试方法执行前，执行
    @BeforeEach
    void beforeEach() {
        System.out.println("@BeforeEach - 在 ( 每个 ) 单元测试方法执行前，执行");
    }

    // 3
    // @AfterEach 在每个单元测试方法执行后，执行
    @AfterEach
    void afterEach() {
        System.out.println("@AfterEach - 在 ( 每个 ) 单元测试方法执行后，执行");
    }


    // 4
    // @BeforeAll 在所有单元测试方法执行前，执行，只执行一次
    // @AfterAll 在所有单元测试方法执行后，执行，只执行一次
    @BeforeAll
    static void beforeAll() {
        System.out.println("@BeforeAll 在 ( 所有 ) 单元测试方法执行前，执行，只会执行一次");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("@AfterAll 在 ( 所有 ) 单元测试方法执行后，执行，只会执行一次");
    }

    // 5
    // @Timeout 超时时抛出超时错误
    @Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
    @Test
    void timeout() throws InterruptedException{
        Thread.sleep(100);
    }

    // 6
    // @RepeatedTest 重复测试
    @RepeatedTest(value = 3)
    void repeatedTest() {
        System.out.println("@RepeatedTest 重复测试");
    }


    @Test
    void testHelloBean() {
        System.out.println(helloBean);
    }

}
