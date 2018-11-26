package com.snowwolf.demojava8.mode.service;

import com.snowwolf.demojava8.mode.eo.UserPayEo;

import java.util.List;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 16:05
 * @modified by:
 * @versions：0.1.0
 */
public interface UserPayService {
    List<UserPayEo> findAll();
}
