package com.snowwolf.demojava8.mode.dao;

import com.snowwolf.demojava8.mode.eo.UserPayEo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author: topsnowwolf
 * @description:
 * @date: Create in 2018/11/25 16:01
 * @modified by:
 * @versions：0.1.0
 */
public interface UserPayRepository extends JpaRepository<UserPayEo,String> {
    List<UserPayEo> findByState(String state);
}
