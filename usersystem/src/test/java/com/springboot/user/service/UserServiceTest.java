package com.springboot.user.service;

import com.springboot.user.pojo.User;
import com.springboot.user.vo.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author 飞鸟
 * @create 2019-11-26 9:50
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class UserServiceTest {
    @Autowired
    private  UserService userService;
    @Test
    public void list2() {
        Page<User> page = userService.list2(1,5, "张");
        System.out.println(page);
    }
}