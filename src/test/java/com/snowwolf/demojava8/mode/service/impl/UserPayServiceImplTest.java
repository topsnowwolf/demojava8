package com.snowwolf.demojava8.mode.service.impl;

import com.snowwolf.demojava8.mode.eo.UserPayEo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 17:52
 * @modified by:
 * @versions：0.1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPayServiceImplTest {
    @Autowired
    private UserPayServiceImpl userPayService;
    @Test
    public void findAll() throws Exception {
        List<UserPayEo> userPayEos = userPayService.findAll();
        System.out.println(userPayEos.stream().count());
    }

}