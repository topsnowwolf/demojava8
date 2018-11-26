package com.snowwolf.demojava8.mode.service;

import com.snowwolf.demojava8.mode.eo.ShopEo;

import java.util.List;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 20:22
 * @modified by:
 * @versions：0.1.0
 */
public interface ShopService {
    List<ShopEo> findAll();
}
