package com.snowwolf.demojava8.mode.dao;

import com.snowwolf.demojava8.mode.eo.ShopEo;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 20:21
 * @modified by:
 * @versions：0.1.0
 */
public interface ShopRepository extends JpaRepository<ShopEo,String> {
}
