package com.snowwolf.demojava8.mode.service.impl;

import com.snowwolf.demojava8.mode.dao.UserPayRepository;
import com.snowwolf.demojava8.mode.eo.UserPayEo;
import com.snowwolf.demojava8.mode.service.UserPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 16:05
 * @modified by:
 * @versions：0.1.0
 */
@Service
public class UserPayServiceImpl implements UserPayService {
    @Autowired
    private UserPayRepository userPayRepository;
    @Override
    public List<UserPayEo> findAll() {
        return userPayRepository.findAll();
    }
}
